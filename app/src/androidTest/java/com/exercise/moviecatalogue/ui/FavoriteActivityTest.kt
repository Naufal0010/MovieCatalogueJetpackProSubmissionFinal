package com.exercise.moviecatalogue.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.utils.DataDummy
import com.exercise.moviecatalogue.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test

class FavoriteActivityTest {

    private val dummyMovie = DataDummy.generateMovies()
    private val dummyTvShow = DataDummy.generateTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(FavoriteActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }


    @Test
    fun loadTvShows() {
        onView(withText(R.string.tv_shows)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }
}