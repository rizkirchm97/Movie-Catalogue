package com.rizki.moviecatalogue.ui.favourite.favouritetvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.data.source.local.entity.TvShowEntity
import com.rizki.moviecatalogue.databinding.ItemsFavTvShowsBinding
import com.rizki.moviecatalogue.ui.detail.tvshows.DetailTvShowsActivity

class TvShowFavouriteAdapter(private val callbackTvShow: TvShowFavouriteFragmentCallback):
    RecyclerView.Adapter<TvShowFavouriteAdapter.TvShowViewHolder>(){

    private val listFavTvShow = ArrayList<TvShowEntity>()

    fun setFavTvShow(favMovie: List<TvShowEntity>?) {
        if (favMovie == null) return
        this.listFavTvShow.clear()
        this.listFavTvShow.addAll(favMovie)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvShowFavouriteAdapter.TvShowViewHolder {
        val itemsFavTvShowBinding = ItemsFavTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsFavTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowFavouriteAdapter.TvShowViewHolder, position: Int) {
        val favTvShow = listFavTvShow[position]
        holder.bind(favTvShow)
    }

    override fun getItemCount(): Int = listFavTvShow.size
    inner class TvShowViewHolder(private val binding: ItemsFavTvShowsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(favTvShow: TvShowEntity) {
            with(binding) {
                tvItemTitleTvShows.text = favTvShow.title
                tvNetworkTvShows.text = favTvShow.network

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailTvShowsActivity::class.java)
                    intent.putExtra(DetailTvShowsActivity.EXTRA_TVSHOWS, favTvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener { callbackTvShow.onShareClick(favTvShow) }
                Glide.with(itemView.context)
                    .load(favTvShow.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPosterTvShows)
            }
        }

    }
}