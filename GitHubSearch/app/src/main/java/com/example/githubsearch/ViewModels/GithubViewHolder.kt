package com.example.githubsearch.ViewModels

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubsearch.databinding.GithubBinding


class GithubViewHolder(private val binding: GithubBinding):
  RecyclerView.ViewHolder(binding.root){

      fun bind(login:String, avatarUrl: String){
          binding.login.text = login

          Glide.with(binding.root)
               .load(avatarUrl)
              .into(binding.avatarUrl)

      }
  }