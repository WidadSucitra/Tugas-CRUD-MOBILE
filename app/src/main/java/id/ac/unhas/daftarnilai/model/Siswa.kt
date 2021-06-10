package id.ac.unhas.daftarnilai.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tabel_siswa")
data class Siswa (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val Nama: String,
    val Kelas: String,
    val tugas: String,
    val mid: String,
    val nilaifinal: String
):Parcelable