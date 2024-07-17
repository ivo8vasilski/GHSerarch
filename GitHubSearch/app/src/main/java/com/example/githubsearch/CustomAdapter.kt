package com.example.githubsearch

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearch.data.Data
import com.example.githubsearch.databinding.TextRowItemBinding
import java.net.URL

class CustomAdapter(private var dataSet: List<Data>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(private val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(myData: Data) {
            binding.textView.text = myData.login
            binding.imageView.setImageURI(Uri.parse(myData.avatarUrl))
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = TextRowItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun setData(data: List<Data>) {
        dataSet = data

        notifyItemRangeChanged(0, data.size)
    }
}
