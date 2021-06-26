package com.rizki.moviecatalogue.ui.detail.tvshows

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
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.databinding.ActivityDetailTvShowsBinding
import com.rizki.moviecatalogue.databinding.ContentDetailTvShowsBinding
import com.rizki.moviecatalogue.viewmodel.ViewModelFactory
import com.rizki.moviecatalogue.vo.Status

class DetailTvShowsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TVSHOWS = "extra_tv_shows"
    }

    private lateinit var activityDetailTvShowsBinding: ActivityDetailTvShowsBinding
    private lateinit var viewModel: DetailTvShowsViewModel
    private var menu: Menu? = null

    private lateinit var contentDetailTvShowsBinding: ContentDetailTvShowsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvShowsBinding = ActivityDetailTvShowsBinding.inflate(layoutInflater)
        contentDetailTvShowsBinding = activityDetailTvShowsBinding.detailContentTvShows
        setContentView(activityDetailTvShowsBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvShowsViewModel::class.java]

        setSupportActionBar(activityDetailTvShowsBinding.toolbarTvShows)
        activityDetailTvShowsBinding.toolbarTvShows.setNavigationOnClickListener { onBackPressed() }

        val extras = intent.extras
        if (extras != null) {
            val tvShowsId = extras.getString(EXTRA_TVSHOWS)
            if (tvShowsId != null) {

                viewModel.setSelectedTvShows(tvShowsId)

                viewModel.tvShows.observe(this, { detailTvSHow ->
                    if (detailTvSHow != null) {
                        when (detailTvSHow.status) {
                            Status.LOADING -> activityDetailTvShowsBinding.progressBar.visibility = View.VISIBLE
                            Status.SUCCESS -> if (detailTvSHow.data != null) {
                                activityDetailTvShowsBinding.progressBar.visibility = View.GONE
                                activityDetailTvShowsBinding.progressBar.visibility = View.VISIBLE

                                populateTvShow(detailTvSHow.data)
                            }
                            Status.ERROR -> {
                                activityDetailTvShowsBinding.progressBar.visibility = View.GONE
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

        viewModel.tvShows.observe(this, { detailTvShow ->
            if (detailTvShow != null) {
                when (detailTvShow.status) {
                    Status.LOADING -> activityDetailTvShowsBinding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> if (detailTvShow.data != null) {
                        activityDetailTvShowsBinding.progressBar.visibility = View.GONE
                        val state = detailTvShow.data.favourite
                        setFavourite(state)
                    }
                    Status.ERROR -> {
                        activityDetailTvShowsBinding.progressBar.visibility = View.GONE
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

    private fun setFavourite(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_fav)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun populateTvShow(tvShowsEntity: TvShowEntity) {
        contentDetailTvShowsBinding.tvDetailTitleTvShows.text = tvShowsEntity.title
        contentDetailTvShowsBinding.tvDetailGenreTvShows.text = tvShowsEntity.genre
        contentDetailTvShowsBinding.tvDetailTtTvShows.text = tvShowsEntity.totalTime
        contentDetailTvShowsBinding.tvDetailNetworkTvShows.text = tvShowsEntity.network
        contentDetailTvShowsBinding.tvDetailQuote.text = tvShowsEntity.quote
        contentDetailTvShowsBinding.tvDetailOverview.text = tvShowsEntity.overview

        Glide.with(this)
            .load(tvShowsEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
            .error(R.drawable.ic_error)
            .into(contentDetailTvShowsBinding.imgPosterTvShows)
    }
}