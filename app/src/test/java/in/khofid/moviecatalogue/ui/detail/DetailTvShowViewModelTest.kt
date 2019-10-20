package `in`.khofid.moviecatalogue.ui.detail

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {
    private lateinit var viewModel: DetailTvShowViewModel
    private val tvShowId = 69050

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
    }

    @Test
    fun getTvShow() {
        viewModel.tvShowId = tvShowId
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(tvShowId, tvShow.id)
        assertEquals("Riverdale", tvShow.title)
        assertEquals("7.2", tvShow.rating.toString())
        assertEquals("/2IUpoKSP64r6rp2vBo0Fdk8a1UU.jpg", tvShow.backdrop)
    }
}