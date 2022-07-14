package com.jekma.maxe.model.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    //設置對外接口
    abstract fun userDao(): UserDao

    companion object {
//        const val DB_NAME = "RecordData.db"
//
        @Volatile
        private var INSTANCE: UserDatabase? = null
//
        fun getDatabase(context: Context):UserDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,UserDatabase::class.java,"user_database").build()
                INSTANCE = instance
                return instance
            }
        }
//
//
//
////        @Synchronized
////        fun getInstance(context: Context): DataBase? {
//////        if(instance == null){
//////            instance = create(context);//創立新的資料庫
//////        }
////            if (instance == null) {
////                instance =
////                    Room.databaseBuilder(context.applicationContext, DataBase::class.java, DB_NAME).addMigrations(MARGIN_1to2).build()
////            }
////            return instance
////        }
////
////        private fun create(context: Context): DataBase {
////            return Room.databaseBuilder(context, DataBase::class.java, DB_NAME).build()
////        }
////
////        var MARGIN_1to2: Migration = object : Migration(1, 2) {
////            override fun migrate(database: SupportSQLiteDatabase) {
////                database.execSQL("ALTER TABLE \"MyTable\"  ADD COLUMN age INTEGER NOT NULL DEFAULT 18")
////            }
////        }
    }
}