package com.example.githubsearch.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.Repository.MainRepository
import com.example.githubsearch.data.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository):
    ViewModel() {


    private var _data = MutableStateFlow<List<Data>>(emptyList())
    var data: StateFlow<List<Data>> = _data

    private var _page: MutableStateFlow<Int> = MutableStateFlow(0)
    private var _query: MutableStateFlow<String?> = MutableStateFlow(null)

    fun getData(): List<String> {
        return mainRepository.getData()
    }


    fun getSearchResults(query: String) {


        viewModelScope.launch {
            try {
                val page = _page.value + 1
                val result = mainRepository.getItems(query, page)

                val currentResults: MutableList<Data> = _data.value.toMutableList()
                currentResults.addAll(result)

                _data.emit(currentResults)
                _page.emit(page)

            } catch (e: Throwable) {
                println("Error: ${e.message}")
                e.message
            }
        }
    }
}

