package bosta.android_task.data.di

import bosta.android_task.data.BuildConfig
import bosta.android_task.data.data_source.service.CitiesAndDistrictsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        client: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(
      logging: HttpLoggingInterceptor,
       headerInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .addInterceptor(headerInterceptor)
            .build()

    }

    @Provides
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
                val originalRequest = chain.request()
                val request = originalRequest.newBuilder().apply {
                method(originalRequest.method, originalRequest.body)
                }
            val requestBuilder = request.build()
            val response = chain.proceed(requestBuilder)
            response
        }
    }

    @Singleton
    @Provides
    fun provideAuthService(
        retrofit: Retrofit
    ): CitiesAndDistrictsService {
        return retrofit.create(CitiesAndDistrictsService::class.java)
    }




}

