package com.pedro.applistaveiculos.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pedro.applistaveiculos.data.DTOs.Veiculo

@Database(entities = [Veiculo::class], version = 1)
abstract class VeiculoDatabase : RoomDatabase() {
    abstract fun veiculoDao(): VeiculoDao

    /**
     * Instancia da DB utilizando o ROOM
     */
    companion object {
        @Volatile
        private var INSTANCE: VeiculoDatabase? = null

        fun getDatabase(context: Context): VeiculoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VeiculoDatabase::class.java,
                    "veiculo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
