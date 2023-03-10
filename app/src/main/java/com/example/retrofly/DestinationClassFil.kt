package com.example.retrofly

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofly.helpers.DestinationAdapter
import com.example.retrofly.models.Destination

class DestinationClassFil(private val destinationList: List<String>):RecyclerView.Adapter<viewHolderS>() {

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderS {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return viewHolderS(view)
    }

    override fun onBindViewHolder(holder: viewHolderS, position: Int) {
        holder.destination = destinationList[position]
        holder.txvDestination.text = destinationList[position].city

        holder.itemView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, DestinationDetailActivity::class.java)
            intent.putExtra(DestinationDetailActivity.ARG_ITEM_ID, holder.destination!!.id)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return destinationList.size
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderS {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return viewHolderS(view)
    }

    override fun onBindViewHolder(holder: viewHolderS, position: Int) {
        holder.txvDestination.text = destinationList[position]
    }

    override fun getItemCount(): Int {
       return destinationList.size
    }

}
class viewHolderS(itemView: View):RecyclerView.ViewHolder(itemView)
{
    var txvDestination: TextView = itemView.findViewById(R.id.txv_destination)

}