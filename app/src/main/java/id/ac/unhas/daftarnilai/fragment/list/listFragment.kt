package id.ac.unhas.daftarnilai.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.ac.unhas.daftarnilai.R
import kotlinx.android.synthetic.main.fragment_list2.view.*

class listFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list2, container, false)

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment2_to_addFragment2)
        }

        return view}

}