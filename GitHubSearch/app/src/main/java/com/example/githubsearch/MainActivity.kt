package com.example.githubsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearch.Repository.MainRepository
import com.example.githubsearch.ViewModels.MainViewModel
import com.example.githubsearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

       private lateinit var binding: ActivityMainBinding
       private lateinit var adapter: CustomAdapter
       private lateinit var mainRepository: MainRepository

       private val viewModel: MainViewModel by viewModels()
       private val isAllEmailLoaded = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.myButton.setOnClickListener {
            val query = binding.textField.text.toString()
            viewModel.getSearchResults(query,)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView. = LinearLayoutManager(this)

        adapter = CustomAdapter(emptyList())
        binding.recyclerView.adapter = adapter



        lifecycleScope.launch {
            viewModel.data.collect { results ->

                adapter.setData(results)
            }
        }
    }




}





