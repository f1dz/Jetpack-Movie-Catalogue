package `in`.khofid.moviecatalogue.ui.tv


import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.utils.DataDummy
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*


class TvShowViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: TvShowViewModel
    private var catalogueRepository = mock(CatalogueRepository::class.java)

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShows() {
        var dummyTvShows = DataDummy.generateDummyTvShow()

        var tvShows: MutableLiveData<List<TvShow>> = MutableLiveData()
        tvShows.postValue(dummyTvShows)

        `when`(catalogueRepository.getAllTvShow()).thenReturn(tvShows)
        val observer = mock(Observer::class.java) as Observer<List<TvShow>>

        viewModel.getTvShows().observeForever(observer)

        verify(observer).onChanged(dummyTvShows)
    }
}