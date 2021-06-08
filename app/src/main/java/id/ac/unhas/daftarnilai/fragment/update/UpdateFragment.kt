package id.ac.unhas.daftarnilai.fragment.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import id.ac.unhas.daftarnilai.R
import id.ac.unhas.daftarnilai.model.Siswa
import id.ac.unhas.daftarnilai.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_add2.*
import kotlinx.android.synthetic.main.fragment_add2.add_kelas
import kotlinx.android.synthetic.main.fragment_add2.add_nama
import kotlinx.android.synthetic.main.fragment_add2.add_tugas
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class UpdateFragment : Fragment() {

    private val args by  navArgs<UpdateFragmentArgs>()
    @InternalCoroutinesApi
    private lateinit var mViewModel: ViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        view.update_nama.setText(args.currentLayout.Nama)
        view.update_kelas.setText(args.currentLayout.Kelas)
        view.update_tugas.setText(args.currentLayout.tugas)
        view.update_mid.setText(args.currentLayout.mid)
        view.update_final.setText(args.currentLayout.nilaifinal)

        view.update_button.setOnClickListener{
            updatenilai()
        }
        return view
    }

    @InternalCoroutinesApi
    private fun updatenilai() {
        val Nama =  update_nama.text.toString()
        val Kelas = update_kelas.text.toString()
        val Tugas = update_tugas.text.toString()
        val Mid = update_mid.text.toString()
        val nilaifinal = update_final.text.toString()

        if(inputCheck(Nama, Kelas, Tugas, Mid, nilaifinal)){
            //Create User Object
            val updateSiswa = Siswa(args.currentLayout.id, Nama, Kelas, Tugas, Mid, nilaifinal)
            //update Data to database
            mViewModel.updateSiswa(updateSiswa)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            //Navigate Back
            findNavController().navigate(R.id.action_updateFragment2_to_listFragment2)

        }else{
            Toast.makeText(requireContext(), "Failed to update", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(Nama: String, Kelas: String, Tugas: String,
                           Mid: String, nilaifinal: String): Boolean{
        return !(TextUtils.isEmpty(Nama) && TextUtils.isEmpty(Kelas) && TextUtils.isEmpty(Tugas) &&
                TextUtils.isEmpty(Mid) && TextUtils.isEmpty(nilaifinal))
    }

}