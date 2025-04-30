package br.com.arml.devhub.di

import br.com.arml.devhub.model.repository.DevHubRepository
import br.com.arml.devhub.model.source.network.DevHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDevHubRepository(service: DevHubApiService) : DevHubRepository {
        return DevHubRepository(service)
    }

}