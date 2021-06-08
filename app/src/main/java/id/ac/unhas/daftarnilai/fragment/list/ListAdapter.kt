package id.ac.unhas.daftarnilai.fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.daftarnilai.R
import id.ac.unhas.daftarnilai.model.Siswa
import kotlinx.android.synthetic.main.items.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var siswaList = emptyList<Siswa>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
    }

    override fun getItemCount(): Int {
        return siswaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = siswaList[position]
        holder.itemView.id_view.text = "${currentItem.id.toString()}."
        holder.itemView.nama.text = "Nama: ${currentItem.Nama}"
        holder.itemView.kelas.text = "Kelas: ${currentItem.Kelas}"
        holder.itemView.tugas.text = "Rata-rata tugas: ${currentItem.tugas}"
        holder.itemView.mid.text = "Nilai mid: ${currentItem.mid}"
        holder.itemView.nilaifinal.text = "Nilai mid: ${currentItem.nilaifinal}"
    }

    fun setData(siswa: List<Siswa>){
        this.siswaList = siswa
        notifyDataSetChanged()
    }
}