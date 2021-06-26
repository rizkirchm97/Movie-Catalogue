package com.rizki.moviecatalogue.ui.detail.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.MovieEntity
import com.rizki.moviecatalogue.databinding.ActivityDetailMoviesBinding
import com.rizki.moviecatalogue.databinding.ContentDetailMoviesBinding
import com.rizki.moviecatalogue.viewmodel.ViewModelFactory
import com.rizki.moviecatalogue.vo.Status

class DetailMoviesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movies"
    }

    private lateinit var activityDetailBinding: ActivityDetailMoviesBinding
    private lateinit var viewModel: DetailMoviesViewModel
    private var menu: Menu? = null

    private lateinit var contentDetailMoviesBinding: ContentDetailMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        contentDetailMoviesBinding = activityDetailBinding.detailContentMovies
        setContentView(activityDetailBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMoviesViewModel::class.java]

        setSupportActionBar(activityDetailBinding.toolbarMovies)
        activityDetailBinding.toolbarMovies.setNavigationOnClickListener { onBackPressed() }

        val extras = intent.extras
        if (extras != null) {
            val moviesId = extras.getString(EXTRA_MOVIES)
            if (moviesId != null) {

                viewModel.setSelectedMovies(moviesId)
                viewModel.movie.observe(this, { detailMovie ->
                    if (detailMovie != null) {
                        when (detailMovie.status) {
                            Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (detailMovie.data != null) {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                activityDetailBinding.progressBar.visibility = View.VISIBLE

                                populateMovies(detailMovie.data)
                            }
                            Status.ERROR -> {
                                activityDetailBinding.progressBar.visibility = View.GONE
                                Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.movie.observe(this, { detailMovie ->
            if (detailMovie != null) {
                when (detailMovie.status) {
                    Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailMovie.data != null) {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        val state = detailMovie.data.favourite
                        setFavouriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_fav) {
            viewModel.setFav()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavouriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_fav)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun populateMovies(moviesEntity: MovieEntity) {
        contentDetailMoviesBinding.tvDetailTitle.text = moviesEntity.title
        contentDetailMoviesBinding.tvDetailRd.text = moviesEntity.releaseDate
        contentDetailMoviesBinding.tvDetailGenre.text = moviesEntity.genre
        contentDetailMoviesBinding.tvDetailTt.text = moviesEntity.totalTime
        contentDetailMoviesBinding.tvDetailQuote.text = moviesEntity.quotes
        contentDetailMoviesBinding.tvDetailOverview.text = moviesEntity.overview

        Glide.with(this)
            .load(moviesEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(contentDetailMoviesBinding.imgPoster)

    }
}