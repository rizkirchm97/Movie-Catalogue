package com.rizki.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.databinding.ItemsMoviesBinding
import com.rizki.moviecatalogue.ui.detail.movies.DetailMoviesActivity

class MoviesFragmentAdapter: RecyclerView.Adapter<MoviesFragmentAdapter.MoviesViewHolder>() {

    private val listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding =
            ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size


   inner class MoviesViewHolder(private val binding: ItemsMoviesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movies: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movies.title
                tvRdMovies.text = itemView.resources.getString(R.string.release_date, movies.releaseDate)
                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, movies.moviesId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

}