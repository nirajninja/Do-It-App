package com.example.noteappmvvm

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat.setBackground
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdapter(private val context: Context, private val listener:INotesAdapter): RecyclerView.Adapter<NoteRVAdapter.NoteViewHolder>() {
    val allNotes=ArrayList<Note>()

    inner class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val textView:TextView=itemView.findViewById<TextView>(R.id.text)
        val deleteButton:ImageView=itemView.findViewById<ImageView>(R.id.deleteButton)
       val layout=itemView.findViewById<ConstraintLayout>(R.id.cd)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note2,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])

        }

        return viewHolder

    }

    override fun getItemCount(): Int {
            return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
    val currentNote=allNotes[position]
        holder.textView.text=currentNote.text

       //holder.layout.setBackgroundResource(R.drawable.bg5)


        val num=(1..10).random()
        when (num) {
            1 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#FF8A80"))
            }
            2 -> { holder.layout.setBackgroundColor(Color.parseColor("#84FFFF"))

            }
            3 -> { holder.layout.setBackgroundColor(Color.parseColor("#8C9EFF"))

            }
            4 -> { holder.layout.setBackgroundColor(Color.parseColor("#EA80FC"))

            }
            5 -> { holder.layout.setBackgroundColor(Color.parseColor("#CCFF90"))

            }

            6 -> { holder.layout.setBackgroundColor(Color.parseColor("#B9F6CA"))

            }

            7 -> { holder.layout.setBackgroundColor(Color.parseColor("#FF9E80"))

            }

            8 -> { holder.layout.setBackgroundColor(Color.parseColor("#FFFF8D"))

            }

            9 -> { holder.layout.setBackgroundColor(Color.parseColor("#69F0AE"))

            }
            else -> {
                holder.layout.setBackgroundColor(Color.parseColor("#9A84C6"))
            }
        }


    }


    fun updateList(newList: List<Note>)
    {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

    interface INotesAdapter{
        fun onItemClicked(note:Note)
    }

}