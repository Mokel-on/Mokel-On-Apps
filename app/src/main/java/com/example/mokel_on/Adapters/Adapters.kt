package com.example.mokel_on.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mokel_on.Data.Data
import com.example.mokel_on.databinding.ListBinding
import java.util.ArrayList


class Adapters(private val list: ArrayList<Data>): RecyclerView.Adapter<Adapters.Holder>() {

    private var onItemClickCallback: OnItemClickCallback?= null

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
       this.onItemClickCallback = onItemClickCallback
   }

   inner class Holder(val binding: ListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(data: Data){

            binding.root.setOnClickListener(){
                onItemClickCallback?.OnItemClicked(data)
            }
            binding.apply {
                contactList.text = data.contact
                namaList.text = data.nama
                ratingList.text = " Rating ${data.Rating.toString()}"

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun OnItemClicked(data: Data)
    }

}



