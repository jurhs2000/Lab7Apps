package com.example.laboratorio5apps.models

/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.laboratorio5apps.models.DAOs.QuestionDAO
import com.example.laboratorio5apps.models.entities.Question
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Question::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {

    //abstract val questionDAO: QuestionDAO
    abstract fun questionDAO(): QuestionDAO

    private class DataBaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.questionDAO())
                }
            }
        }

        suspend fun populateDatabase(questionDAO: QuestionDAO) {
            // Delete all content here.
            questionDAO.deleteAll()

            // Add sample words.
            var question = Question(0,"¿Qué le pareció nuestro servicio?",3,true)
            questionDAO.insert(question)
            question = Question(0,"¿Tiene algún comentario o sugerencia?",1,true)
            questionDAO.insert(question)

        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context, scope: CoroutineScope): DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "lab6_db"
                    ).fallbackToDestructiveMigration().addCallback(DataBaseCallback(scope))
                        .allowMainThreadQueries().build()
                    /**
                     * AllowMainThreadQueries sirve para permitir peticiones a la base de datos
                     * usando el hilo principal, lo cual puede bloquear el ui, pero, en este
                     * caso es solo utilizado al inicio de la app para ingresar la data inicial.
                     * Todas las demas llamadas en repositorios deben hacerse con cuidado para
                     * no utilizar indebidamente este metodo.
                     */
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}