package com.example.mokel_on.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mokel_on.Data.Data
import com.example.mokel_on.databinding.ListBinding

class Adapters(): RecyclerView.Adapter<Adapters.Holder>() {

    private var onItemClickCallback: OnItemClickCallback?= null

    private val list: ArrayList<Data>()

   fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
       this.onItemClickCallback = onItemClickCallback
   }

     inner class Holder(val binding: ListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}

    interface OnItemClickCallback {
        fun OnItemClicked(data: Data)

}
