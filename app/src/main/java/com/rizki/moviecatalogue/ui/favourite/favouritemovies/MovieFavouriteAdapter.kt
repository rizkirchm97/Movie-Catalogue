package com.rizki.moviecatalogue.ui.favourite.favouritemovies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.databinding.ItemsFavMovieBinding
import com.rizki.moviecatalogue.ui.detail.movies.DetailMoviesActivity

class MovieFavouriteAdapter(private val callbackMovie: MovieFavouriteFragmentCallback):
    RecyclerView.Adapter<MovieFavouriteAdapter.MovieViewHolder>() {

    private val listFavMovie = ArrayList<MovieEntity>()

    fun setFavMovies(favMovie: List<MovieEntity>?) {
        if (favMovie == null) return
        this.listFavMovie.clear()
        this.listFavMovie.addAll(favMovie)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsFavMovieBinding = ItemsFavMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsFavMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val favMovie = listFavMovie[position]
        holder.bind(favMovie)
    }

    override fun getItemCount(): Int = listFavMovie.size

    inner class MovieViewHolder(private val binding: ItemsFavMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favMovie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = favMovie.title
                tvRdMovies.text = itemView.resources.getString(R.string.release_date, favMovie.releaseDate)

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailMoviesActivity::class.java)
                    intent.putExtra(DetailMoviesActivity.EXTRA_MOVIES, favMovie.moviesId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callbackMovie.onShareClick(favMovie) }
                Glide.with(itemView.context)
                    .load(favMovie.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }

    }
}