package ir.hoseinahmadi.daneshjooyarapllication.Room.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.hoseinahmadi.daneshjooyarapllication.Room.Constance
import ir.hoseinahmadi.daneshjooyarapllication.Room.ShopDatabase
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(
        context,
        ShopDatabase::class.java,
        Constance.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideShopDao(database: ShopDatabase) = database.ShopDao()

    @Singleton
    @Provides
    fun provideFaveDao(database: ShopDatabase) = database.FaveDao()


}
