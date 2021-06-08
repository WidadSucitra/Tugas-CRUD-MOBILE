package id.ac.unhas.daftarnilai.fragment.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.daftarnilai.R
import id.ac.unhas.daftarnilai.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_list2.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class listFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mViewModel: ViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list2, container, false)

        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        mViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment2_to_addFragment2)
        }

        return view}

}