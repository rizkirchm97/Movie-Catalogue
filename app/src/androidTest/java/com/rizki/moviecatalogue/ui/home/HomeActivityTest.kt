package com.rizki.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.rizki.moviecatalogue.R
import com.rizki.moviecatalogue.utils.DataDummy
import com.rizki.moviecatalogue.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generatedDummyTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_detail_rd)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rd)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dummyMovies[0].genre)))
        onView(withId(R.id.tv_detail_tt)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tt)).check(matches(withText(dummyMovies[0].totalTime)))
        onView(withId(R.id.tv_detail_quote)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_quote)).check(matches(withText(dummyMovies[0].quotes)))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_title_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title_tvShows)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.tv_detail_network_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_network_tvShows)).check(matches(withText(dummyTvShows[0].network)))
        onView(withId(R.id.tv_detail_genre_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_tvShows)).check(matches(withText(dummyTvShows[0].genre)))
        onView(withId(R.id.tv_detail_tt_tvShows)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tt_tvShows)).check(matches(withText(dummyTvShows[0].totalTime)))
        onView(withId(R.id.tv_detail_quote)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_quote)).check(matches(withText(dummyTvShows[0].quote)))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.img_poster_tvShows)).check(matches(isDisplayed()))


    }
}