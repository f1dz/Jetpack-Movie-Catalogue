package `in`.khofid.moviecatalogue.ui.tv

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.testing.SingleFragmentActivity
import `in`.khofid.moviecatalogue.utils.RecyclerViewItemCountAssertion
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TvFragmentTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    var fragment = TvFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(fragment)
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).check(RecyclerViewItemCountAssertion(20))
    }

}