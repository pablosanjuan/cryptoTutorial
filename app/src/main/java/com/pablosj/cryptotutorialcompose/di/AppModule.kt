package com.pablosj.cryptotutorialcompose.di

import android.provider.ContactsContract.Data
import com.pablosj.cryptotutorialcompose.common.Constants.BASE_URL
import com.pablosj.cryptotutorialcompose.data.remote.DataSourceApi
import com.pablosj.cryptotutorialcompose.data.repository.ItemRepositoryImpl
import com.pablosj.cryptotutorialcompose.domain.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProvideDataSourceApi(): DataSourceApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataSourceApi::class.java)
    }


    @Provides
    @Singleton
    fun provideItemRepository(api: DataSourceApi): ItemRepository {
        return ItemRepositoryImpl(api = api)
    }
}