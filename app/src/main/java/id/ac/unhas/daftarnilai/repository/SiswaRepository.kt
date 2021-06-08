package id.ac.unhas.daftarnilai.repository

import androidx.lifecycle.LiveData
import id.ac.unhas.daftarnilai.datapackage.SiswaDao
import id.ac.unhas.daftarnilai.model.Siswa

class SiswaRepository (private val siswaDao: SiswaDao){

    val readAllData: LiveData<List<Siswa>> = siswaDao.readAllData()

    suspend fun addNilai(siswa: Siswa){
        siswaDao.addNilai(siswa)
    }

    suspend fun updateNilai(siswa: Siswa){
        siswaDao.updateNilai(siswa)
    }

}