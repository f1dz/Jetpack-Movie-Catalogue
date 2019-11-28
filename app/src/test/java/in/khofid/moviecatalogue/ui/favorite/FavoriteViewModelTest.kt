package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class FavoriteViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: FavoriteViewModel
    private var catalogueRepository = mock(CatalogueRepository::class.java)

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyMovies = MutableLiveData<PagedList<Movie>>()
        var pagedList: PagedList<Movie> = mock(PagedList::class.java) as PagedList<Movie>
        dummyMovies.value = pagedList

        `when`(catalogueRepository.getAllFavoriteMovies()).thenReturn(dummyMovies)
        val observer = mock(Observer::class.java) as Observer<PagedList<Movie>>

        viewModel.getMovies().observeForever(observer)

        verify(observer).onChanged(pagedList)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyShows = MutableLiveData<PagedList<TvShow>>()
        var pagedList: PagedList<TvShow> = mock(PagedList::class.java) as PagedList<TvShow>
        dummyShows.value = pagedList

        `when`(catalogueRepository.getAllFavoriteTvShows()).thenReturn(dummyShows)
        val observer = mock(Observer::class.java) as Observer<PagedList<TvShow>>

        viewModel.getTvShows().observeForever(observer)

        verify(observer).onChanged(pagedList)
    }
}