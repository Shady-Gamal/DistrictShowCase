package bosta.android_task.data.di

import bosta.android_task.data.repository.cities_and_districs.CitiesAndDistrictsRepositoryImpl
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    @Singleton
    abstract fun bindCitiesAndDistrictsRepository(citiesAndDistrictsRepositoryImpl: CitiesAndDistrictsRepositoryImpl) : CitiesAndDistrictsRepository

}