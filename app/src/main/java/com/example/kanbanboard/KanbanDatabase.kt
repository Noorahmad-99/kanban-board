package com.example.kanbanboard

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [KanbanBoard::class] , version = 1)
abstract class KanbanDatabase :RoomDatabase()  {

        abstract fun updateDao() : KanbanDao?

        companion object{

            private const val DATABASE_NAME = " My database"

            @Volatile private var instance : KanbanDatabase? = null

            fun getInstance (context: Context) :KanbanDatabase {
                return  instance?: synchronized(this) { bulidDatabase(context).also { instance = it } }
            }


            fun getInstanceError() :KanbanDatabase{
                return instance!!
            }

            private fun bulidDatabase(context: Context) : KanbanDatabase {
                return Room.databaseBuilder(context, KanbanDatabase::class.java , DATABASE_NAME).build()
            }
        }

}