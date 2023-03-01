package com.example.apimoviedbcommvvm.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apimoviedbcommvvm.databinding.ItemMovieBinding
import com.example.apimoviedbcommvvm.models.Movie
import com.example.apimoviedbcommvvm.view.DetailsActivity
import com.squareup.picasso.Picasso

class MovieAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var moviesAdapter = mutableListOf<Movie>()

    fun createListOfMovies(movie: List<Movie>){
        moviesAdapter = movie.toMutableList()
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemValues = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemValues)
    }

    override fun getItemCount(): Int {
        return moviesAdapter.size

    }




    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MovieViewHolder ->{
                holder.bind(moviesAdapter[position])
            }
        }
    }


    class MovieViewHolder constructor(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        private val titleMovie =  binding.textTitle
        private val imagePoster =  binding.imagePoster

        fun bind(movie: Movie){
            titleMovie.text = movie.title

            Picasso.get()
                .load("https://image.tmdb.org/t/p/original" + movie.poster)
                .resize(400,400)
                .placeholder(com.example.apimoviedbcommvvm.R.drawable.ic_launcher_background)
                .error(com.example.apimoviedbcommvvm.R.drawable.ic_launcher_background)
                .into(imagePoster)


            imagePoster.setOnClickListener {
                val intentTitle = movie.title
                val intentImage = movie.poster
                val intentDescription = movie.description

                val intent = Intent(itemView.context, DetailsActivity::class.java)
                intent.putExtra("title", intentTitle)
                intent.putExtra("image", intentImage)
                intent.putExtra("description", intentDescription)
                itemView.context.startActivity(intent)
            }
        }
    }
}