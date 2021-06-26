package com.rizki.moviecatalogue.ui.favourite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.ui.favourite.favouritemovies.MovieFavouriteFragment
import com.rizki.moviecatalogue.ui.favourite.favouritetvshow.TvShowFavouriteFragment

class SectionsPagerAdapter(private val mContext: Context?, fm: FragmentManager?): FragmentPagerAdapter(
    fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.Movies, R.string.tvShows)
    }
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFavouriteFragment()
            1 -> TvShowFavouriteFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext?.resources?.getString(TAB_TITLES[position])
}