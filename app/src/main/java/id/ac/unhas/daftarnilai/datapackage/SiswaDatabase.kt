package id.ac.unhas.daftarnilai.datapackage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.unhas.daftarnilai.model.Siswa
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities =  [Siswa::class], version = 1, exportSchema = false)
abstract class SiswaDatabase:RoomDatabase() {

    abstract fun siswaDao():SiswaDao

    companion object{
        @Volatile
        private var INSTANCE: SiswaDatabase? = null

        fun getDatabase(context: Context): SiswaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            kotlin.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SiswaDatabase::class.java,
                    "database_siswa"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}