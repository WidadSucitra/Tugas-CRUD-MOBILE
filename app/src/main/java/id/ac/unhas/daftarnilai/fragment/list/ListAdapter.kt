package id.ac.unhas.daftarnilai.fragment.list

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.daftarnilai.R
import id.ac.unhas.daftarnilai.model.Siswa
import id.ac.unhas.daftarnilai.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.android.synthetic.main.items.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private lateinit var mViewModel: ViewModel
    private var siswaList = emptyList<Siswa>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
    }

    override fun getItemCount(): Int {
        return siswaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = siswaList[position]
        holder.itemView.nama.text = "Nama: ${currentItem.Nama}"
        holder.itemView.kelas.text = "Kelas: ${currentItem.Kelas}"
        holder.itemView.tugas.text = "Rata-rata tugas: ${currentItem.tugas}"
        holder.itemView.mid.text = "Nilai mid: ${currentItem.mid}"
        holder.itemView.nilaifinal.text = "Nilai mid: ${currentItem.nilaifinal}"

        holder.itemView.itemlayout.setOnClickListener {
            val action = listFragmentDirections.actionListFragment2ToUpdateFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    fun setData(siswa: List<Siswa>){
        this.siswaList = siswa
        notifyDataSetChanged()
    }

}