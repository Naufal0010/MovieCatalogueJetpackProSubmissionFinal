package com.exercise.moviecatalogue.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.exercise.moviecatalogue.R
import com.exercise.moviecatalogue.utils.DataDummy
import com.exercise.moviecatalogue.utils.EspressoIdlingResources
import org.junit.After
import org.junit.Before
import org.junit.Test


class MainActivityTest {

    private val dummyMovie = DataDummy.generateMovies()
    private val dummyTvShow = DataDummy.generateTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
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
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.image_view_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_length)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_length)).check(matches(withText(dummyMovie[0].length)))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(dummyMovie[0].release)))
    }

    @Test
    fun loadTvShows() {
        onView(withText(R.string.tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyTvShow.size
                )
        )
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText(R.string.tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyTvShow[0].description)))
        onView(withId(R.id.image_view_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShow[0].genre)))
        onView(withId(R.id.tv_length)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_length)).check(matches(withText(dummyTvShow[0].length)))
        onView(withId(R.id.tv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release)).check(matches(withText(dummyTvShow[0].release)))
    }

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyMovie.size
                )
        )
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyMovie.size
                )
        )
        onView(withId(R.id.rv_movies)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())

    }

    @Test
    fun loadFavoriteTvShow() {
        onView(withText(R.string.tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyMovie.size
                )
        )
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withText(R.string.tv_shows)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                        dummyMovie.size
                )
        )
        onView(withId(R.id.rv_tv_shows)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.fab_favorite)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.favorite)).perform(click())
        onView(withText(R.string.tv_shows)).perform(click())
    }
}