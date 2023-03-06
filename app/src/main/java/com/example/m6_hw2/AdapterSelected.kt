package com.example.m6_hw2

import android.annotation.SuppressLint
import android.net.Uri
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.m6_hw2.databinding.SelectedItemBinding

class AdapterSelected : RecyclerView.Adapter<AdapterSelected.ViewHolder>() {

    private val listGet = arrayListOf<Uri>()
    @SuppressLint("NotifyDataSetChanged")
    fun addPhoto(listTask: List<Uri>) {
        listGet.addAll(listTask)
        notifyDataSetChanged ()
    }

    inner class ViewHolder(private val binding: SelectedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(get: Uri) {
            Glide.with(binding.tvPhoto).load(get).into(binding.tvPhoto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SelectedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listGet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listGet[position])
    }
}





