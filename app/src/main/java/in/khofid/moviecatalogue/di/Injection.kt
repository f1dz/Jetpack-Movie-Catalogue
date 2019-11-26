package `in`.khofid.moviecatalogue.di

import `in`.khofid.moviecatalogue.data.source.CatalogueRepository
import `in`.khofid.moviecatalogue.data.source.local.LocalRepository
import `in`.khofid.moviecatalogue.data.source.remote.RemoteRepository
import android.app.Application

class Injection {
    companion object {
        fun provideRepository(application: Application): CatalogueRepository {
            val remoteRepository = RemoteRepository.getInstance()
            val localRepository = LocalRepository.getInstance(application)
            return CatalogueRepository.getInstance(remoteRepository, localRepository)
        }
    }
}