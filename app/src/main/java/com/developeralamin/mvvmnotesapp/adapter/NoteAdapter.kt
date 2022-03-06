package com.developeralamin.mvvmnotesapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.developeralamin.mvvmnotesapp.R
import com.developeralamin.mvvmnotesapp.databinding.ItemNoteBinding
import com.developeralamin.mvvmnotesapp.model.Notes
import com.developeralamin.mvvmnotesapp.ui.fragment.HomeFragmentDirections

class NoteAdapter(val requireContext: Context, val notesList: List<Notes>) :

    RecyclerView.Adapter<NoteAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {

        return notesViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {

        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text = data.subTitle
        holder.binding.notesDetails.text = data.notes
        holder.binding.noteDate.text = data.date

        when (data.priority) {
            "1" -> {
                holder.binding.ViewPriority.setBackgroundResource(R.drawable.green)
            }
            "2" -> {
                holder.binding.ViewPriority.setBackgroundResource(R.drawable.yellow)
            }
            "3" -> {
                holder.binding.ViewPriority.setBackgroundResource(R.drawable.red)
            }
        }

        holder.binding.root.setOnClickListener {

            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }

    override fun getItemCount() = notesList.size
}