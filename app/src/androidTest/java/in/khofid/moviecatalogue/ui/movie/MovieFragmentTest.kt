package `in`.khofid.moviecatalogue.ui.movie

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.testing.SingleFragmentActivity
import `in`.khofid.moviecatalogue.utils.EspressoIdlingResource
import `in`.khofid.moviecatalogue.utils.RecyclerViewItemCountAssertion
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieFragmentTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private var fragment = MovieFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
        activityRule.activity.setFragment(fragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).check(RecyclerViewItemCountAssertion(20))
    }
}