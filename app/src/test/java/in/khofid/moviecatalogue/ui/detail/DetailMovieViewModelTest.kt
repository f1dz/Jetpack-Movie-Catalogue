package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailMovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: DetailMovieViewModel
    private var repository = mock(CatalogueRepository::class.java)
    private var dummyMovie = DataDummy.generateDummyMovies()[0]
    private var movieId = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
        viewModel.movieId = movieId
    }

    @Test
    fun getMovie() {
        var movie: MutableLiveData<Movie> = MutableLiveData()
        movie.postValue(dummyMovie)

        `when`(repository.getMovie(movieId)).thenReturn(movie)

        val observer = mock(Observer::class.java) as Observer<Movie>

        viewModel.getMovie().observeForever(observer)

        verify(observer).onChanged(dummyMovie)
    }
}