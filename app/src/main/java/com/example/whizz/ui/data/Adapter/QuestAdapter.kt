package com.example.whizz.ui.data.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.whizz.R
import com.example.whizz.ui.data.model.Quest

class QuestAdapter (val context: Context): RecyclerView.Adapter<QuestAdapter.QuestViewHolder>()
{

    private val quests: MutableList<Quest> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestViewHolder
    {
        return QuestViewHolder(LayoutInflater.from(context).inflate(R.layout.item_ongoing_quest, parent, false))
    }

    override fun getItemCount(): Int
    {
        return quests.size
    }

    override fun onBindViewHolder(holder: QuestAdapter.QuestViewHolder, position: Int)
    {
        holder.bindmodel(quests[position])
    }

    fun setQuest(data: List<Quest>)
    {
        quests.clear()
        quests.addAll(data)
        notifyDataSetChanged()
    }

    inner class QuestViewHolder(item: View):RecyclerView.ViewHolder(item)
    {
        val textTitle: TextView = item.findViewById(R.id.ongoingquesttitle)
//        val textDescription: TextView = item.findViewById(R.id.ongoingquesttitle)
        fun bindmodel(q: Quest)
        {
            textTitle.text = q.GetQuestTitle()
        }
    }
}