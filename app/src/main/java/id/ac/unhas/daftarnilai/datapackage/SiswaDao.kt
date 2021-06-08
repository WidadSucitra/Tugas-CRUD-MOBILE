package id.ac.unhas.daftarnilai.datapackage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unhas.daftarnilai.model.Siswa

@Dao
interface SiswaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNilai(siswa:Siswa)

    @Query("SELECT * FROM tabel_siswa ORDER BY id ASC")
    fun readAllData():LiveData<List<Siswa>>
}