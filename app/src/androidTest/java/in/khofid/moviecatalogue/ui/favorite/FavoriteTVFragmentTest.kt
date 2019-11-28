package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.testing.SingleFragmentActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FavoriteTVFragmentTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private var fragment = FavoriteTVFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(fragment)
    }

    @Test
    fun loadFavoriteTvShows() {
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rvTvShow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<FavoriteTvShowViewHolder>(0,
                ViewActions.click()
            ))
        Espresso.onView(ViewMatchers.withId(R.id.tvTitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fabFavorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}