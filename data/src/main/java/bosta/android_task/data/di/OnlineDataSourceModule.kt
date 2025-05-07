package bosta.android_task.data.di


import bosta.android_task.data.data_source.data_source_imp.cities_and_districts.CitiesAndDistrictsRemoteDatsSourceImpl
import bosta.android_task.domain.repository.cities_and_districts.CitiesAndDistrictsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class OnlineDataSourceModule {

      @Binds
      @Singleton
    abstract fun bindCitiesAndDistrictsRemoteDataSource(citiesAndDistrictsRemoteDatsSourceImpl: CitiesAndDistrictsRemoteDatsSourceImpl) : CitiesAndDistrictsRemoteDataSource

}