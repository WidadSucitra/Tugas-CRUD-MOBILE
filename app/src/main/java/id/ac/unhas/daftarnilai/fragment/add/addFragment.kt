package id.ac.unhas.daftarnilai.fragment.add


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.unhas.daftarnilai.R
import id.ac.unhas.daftarnilai.model.Siswa
import id.ac.unhas.daftarnilai.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_add2.*
import kotlinx.android.synthetic.main.fragment_add2.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class addFragment : Fragment() {

    private lateinit var mViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add2, container, false)

        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        view.add_button.setOnClickListener{
            insertDatatoDatabase()
        }

        return view
    }

    private fun insertDatatoDatabase() {
        val Nama =  add_nama.text.toString()
        val Kelas = add_kelas.text.toString()
        val Tugas = add_tugas.text.toString()
        val Mid = add_mid.text.toString()
        val nilaifinal = add_final.text.toString()

        if(inputCheck(Nama, Kelas, Tugas, Mid, nilaifinal)){
            //Create User Object
            val siswa = Siswa(0, Nama, Kelas, Tugas, Mid, nilaifinal)
            //Add Data to database
            mViewModel.addSiswa(siswa)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment2_to_listFragment2)

        }else{
            Toast.makeText(requireContext(), "Failed to add, please check again", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(Nama: String, Kelas: String, Tugas: String,
                           Mid: String, nilaifinal: String): Boolean{
        return !(TextUtils.isEmpty(Nama) && TextUtils.isEmpty(Kelas) && TextUtils.isEmpty(Tugas) &&
                TextUtils.isEmpty(Mid) && TextUtils.isEmpty(nilaifinal))
    }

}