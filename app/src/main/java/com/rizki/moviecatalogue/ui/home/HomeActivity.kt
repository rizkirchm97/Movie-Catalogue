package com.rizki.moviecatalogue.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.databinding.ActivityHomeBinding
import com.rizki.moviecatalogue.ui.favourite.FavouriteFragment
import com.rizki.moviecatalogue.ui.movies.MoviesFragment
import com.rizki.moviecatalogue.ui.tvshows.TvShowsFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

//        setBottomNavigation()
        supportActionBar?.elevation = 0f

        val firstFragment= MoviesFragment()
        val secondFragment= TvShowsFragment()
        val thirdFragment= FavouriteFragment()

        setCurrentFragment(firstFragment)

        activityHomeBinding.mainBottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_movie -> setCurrentFragment(firstFragment)
                R.id.nav_tvShow -> setCurrentFragment(secondFragment)
                R.id.nav_fav -> setCurrentFragment(thirdFragment)
        }
            true
    }

//    private fun setBottomNavigation() {
//        val bottomNav = activityHomeBinding.mainBottomNav
//        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        NavigationUI.setupWithNavController(
//                bottomNav,
//                navHost.navController
//            )
//        val navView: BottomNavigationView = activityHomeBinding.mainBottomNav
//        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration.Builder(
//            R.id.nav_home, R.id.nav_tvShow, R.id.nav_fav
//        ).build()
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.page_container, fragment)
            commit()
        }
}