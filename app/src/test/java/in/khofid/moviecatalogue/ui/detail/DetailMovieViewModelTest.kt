package `in`.khofid.moviecatalogue.ui.detail

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val movieId = 475557

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
    }

    @Test
    fun getMovie() {
        viewModel.movieId = movieId
        val movie = viewModel.getMovie()
        assertNotNull(movie)
        assertEquals(movieId, movie.id)
        assertEquals("Joker", movie.title)
        assertEquals((8.6).toString(), movie.vote.toString())
        assertEquals("/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", movie.poster)
    }
}