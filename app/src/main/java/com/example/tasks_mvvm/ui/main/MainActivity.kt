package com.example.tasks_mvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasks_mvvm.databinding.ActivityMainBinding
import com.example.tasks_mvvm.ui.adapter.TaskAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.tasks.observe(this, Observer {
            adapter.submitDataset(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun setUpRecyclerView() {
        binding.recyclerTasks.layoutManager = LinearLayoutManager(this)
        binding.recyclerTasks.adapter = adapter
    }


}
