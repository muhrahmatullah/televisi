package com.app.muhrahmatullah.dicodingjetpackmovie.movie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.app.muhrahmatullah.dicodingjetpackmovie.HomeActivity
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by muh.rahmatullah on 2019-09-30.
 */
@RunWith(AndroidJUnit4::class)
class AppFlowTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(HomeActivity::class.java, true, true)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoIdlingResource)
    }

    @After
    fun tearDownAll() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoIdlingResource)
    }

    //this test will be refactored using a proper code
    @Test
    fun checkMovie() {
        //check if the tabs and view pager are displayed properly
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))

        //check if recylerview movie exist
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
        //perfrom click on index 0
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        //check if the overview text is displayed
        onView(withId(R.id.textView2)).check(matches(isDisplayed()))
    }

    //this test will be refactored using a proper code
    @Test
    fun checkTvSeries() {
        //check if the tabs and view pager are displayed properly
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))

        //check if recylerview movie exist
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
        // swipe left to view pager
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        //perfrom click on index 0
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.textView2)).check(matches(isDisplayed()))
    }


}