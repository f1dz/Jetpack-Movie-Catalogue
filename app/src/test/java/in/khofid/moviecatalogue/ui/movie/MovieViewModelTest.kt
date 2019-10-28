package `in`.khofid.moviecatalogue.ui.movie

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

class MovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MovieViewModel
    private var repository = mock(CatalogueRepository::class.java)

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        var dummyMovies = DataDummy.generateDummyMovies()
        var movies: MutableLiveData<List<Movie>> = MutableLiveData()
        val observer = mock(Observer::class.java) as Observer<List<Movie>>

        movies.postValue(dummyMovies)

        `when`(repository.getAllMovies()).thenReturn(movies)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}