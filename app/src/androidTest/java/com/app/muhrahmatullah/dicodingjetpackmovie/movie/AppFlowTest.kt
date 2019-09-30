package com.app.muhrahmatullah.dicodingjetpackmovie.movie

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.app.muhrahmatullah.dicodingjetpackmovie.HomeActivity
import com.app.muhrahmatullah.dicodingjetpackmovie.R
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

    //this test will be refactored using a proper code
    @Test
    fun checkMovie() {
        //check if the tabs and view pager are displayed properly
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))

        //check if recylerview movie exist
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
        // pick one movie in movie fragment index 0
        onView(withText("A Star is Born")).perform(click())
        // need to refactor this using idling resources
        // if this line is deleted, the test won't passed since it needs to wait untill the transition finished
        Thread.sleep(1001)
        onView(withText("A Star is Born")).check(matches(isDisplayed()))
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
        // pick one movie in movie fragment index 0
        onView(withText("Arrow")).perform(click())
        // need to refactor this using idling resources
        // if this line is deleted, the test won't passed since it needs to wait untill the transition finished
        Thread.sleep(1001)
        onView(withText("Arrow")).check(matches(isDisplayed()))
    }


}