package com.app.muhrahmatullah.dicodingjetpackmovie.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.app.muhrahmatullah.dicodingjetpackmovie.R
import com.app.muhrahmatullah.dicodingjetpackmovie.testing.SingleFragmentActivity
import com.app.muhrahmatullah.dicodingjetpackmovie.ui.home.HomeFragment
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by muh.rahmatullah on 2019-09-30.
 */
@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    private val homeFragment = TestHomeFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(homeFragment)
    }

    @Test
    fun homeTest() {
        //check if the tabs and view pager are displayed properly
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()))
    }

    class TestHomeFragment : HomeFragment()

}