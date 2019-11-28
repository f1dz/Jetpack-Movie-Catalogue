package `in`.khofid.moviecatalogue.ui

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.ui.home.HomeActivity
import `in`.khofid.moviecatalogue.ui.movie.MovieAdapter
import `in`.khofid.moviecatalogue.ui.tv.TvShowAdapter
import `in`.khofid.moviecatalogue.utils.EspressoIdlingResource
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieCatalogueTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun toDetailMovieActivityTest() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<MovieAdapter.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.fabFavorite)).check(matches(isDisplayed()))
        onView(withId(R.id.fabFavorite)).perform(click())
    }

    @Test
    fun toDetailTvShowActivityTest() {
        onView(withId(R.id.nav_view)).check(matches(isDisplayed()))
        onView(allOf(withText("TV Show"), isDescendantOfA(withId(R.id.nav_view)), isDisplayed())).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<TvShowAdapter.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.fabFavorite)).check(matches(isDisplayed()))
        onView(withId(R.id.fabFavorite)).perform(click())
    }
}