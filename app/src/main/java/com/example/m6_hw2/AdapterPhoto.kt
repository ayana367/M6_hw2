package com.example.m6_hw2

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m6_hw2.databinding.PhotoItemBinding

class AdapterPhoto(private val OnClick: (Uri) -> Unit, private val deleteClick: (Uri) -> Unit) :
    RecyclerView.Adapter<AdapterPhoto.ViewHolder>() {
    private val list = arrayListOf<Uri>()

    @SuppressLint("NotifyDataSetChanged")
    fun addTask(listTask: Uri) {
        list.addAll(listOf(listTask))
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(img: Uri) {
            Glide.with(binding.ivPhoto).load(img).into(binding.ivPhoto)
            binding.ivPhoto.setOnClickListener {
                if (!binding.selected.isVisible) {
                    OnClick(img)
                    binding.selected.visibility = View . VISIBLE
                } else {
                    deleteClick(img)
                    binding.selected.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}