package com.siddharth.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.siddharth.retrofit.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: recyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create an api interface then create a data class which has the data type same as the json file.
        // create a retrofitInstance object which contains the retrofit builder reffering api interface

        lifecycleScope.launchWhenCreated {
            binding.progBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, e.toString(), Toast.LENGTH_SHORT).show()
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                val todoList = response.body()!!
                todoAdapter = recyclerViewAdapter(todoList)
                val layoutManager = LinearLayoutManager(this@MainActivity)
                binding.recView.layoutManager = layoutManager
                binding.recView.adapter = todoAdapter

            }else{
                Toast.makeText(this@MainActivity,"Error Occured",Toast.LENGTH_SHORT).show()
            }
            binding.progBar.isVisible = false
        }


    }
}