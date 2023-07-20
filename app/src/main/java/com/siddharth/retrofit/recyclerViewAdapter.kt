package com.siddharth.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siddharth.retrofit.databinding.ItemTodoBinding

class recyclerViewAdapter(private val TodoList: List<TodoData>) :
    RecyclerView.Adapter<recyclerViewAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = TodoList.size


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = TodoList[position]
            title.text = todo.title
            checkBox.isChecked = todo.completed
        }
    }


}