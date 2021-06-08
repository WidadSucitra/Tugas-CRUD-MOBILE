package id.ac.unhas.daftarnilai.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.ac.unhas.daftarnilai.datapackage.SiswaDatabase
import id.ac.unhas.daftarnilai.model.Siswa
import id.ac.unhas.daftarnilai.repository.SiswaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class ViewModel (application: Application):AndroidViewModel(application){

    val readAllData: LiveData<List<Siswa>>
    private val repository: SiswaRepository

    init{
        val userDao = SiswaDatabase.getDatabase(application).siswaDao()
        repository = SiswaRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addSiswa(siswa: Siswa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNilai(siswa)
        }
    }

    fun updateSiswa(siswa: Siswa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNilai(siswa)
        }
    }
}