package com.example.lab_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_2.model.Book

class BookAdapter(
    private val books: List<Book>,
    private val navController: NavController
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val shortDescriptionTextView: TextView = itemView.findViewById(R.id.shortDescriptionTextView)
        val layout: LinearLayout = itemView.findViewById(R.id.layout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]

        Glide.with(holder.imageView.context).load(book.url).into(holder.imageView)

        holder.nameTextView.text = book.name
        holder.shortDescriptionTextView.text = book.shortDescription

        holder.layout.setOnClickListener {
            navController.navigate(
                MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    book
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
