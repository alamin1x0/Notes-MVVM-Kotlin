package com.developeralamin.mvvmnotesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.developeralamin.mvvmnotesapp.R
import com.developeralamin.mvvmnotesapp.adapter.NoteAdapter
import com.developeralamin.mvvmnotesapp.databinding.FragmentHomeBinding
import com.developeralamin.mvvmnotesapp.viewmodel.NotesViewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner, { notesList ->

            binding.recAllNotes.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.recAllNotes.adapter = NoteAdapter(requireContext(), notesList)
        })

        binding.btnAdd.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }

}