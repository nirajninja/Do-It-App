package com.example.noteappmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NoteRVAdapter.INotesAdapter {
    lateinit var viewModel:NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StaggeredGridLayoutManager(
            2, // span count
            StaggeredGridLayoutManager.VERTICAL // orientation
        ).apply {
            // specify the layout manager for recycler view
            recyclerView.layoutManager = this
        }

        val adapter=NoteRVAdapter(this,this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
    viewModel.allNotes.observe(this, Observer {list->
        list?.let{
            adapter.updateList(it)
        }


    })


    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"item deleted",Toast.LENGTH_SHORT).show()


    }

    fun SubmitData(view: View) {
        val noteText=input.text.toString()
        input.text.clear()
        if(noteText.isNotEmpty())
        {
            viewModel.insertNote(Note(noteText))

        }

    }
}