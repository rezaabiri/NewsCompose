package ir.mobilemaster.newscompose.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobilemaster.newscompose.data.manager.LocalUserManagerImpl
import ir.mobilemaster.newscompose.domain.manager.LocalUserManager
import ir.mobilemaster.newscompose.domain.usecases.AppEntryUseCases
import ir.mobilemaster.newscompose.domain.usecases.ReadAppEntry
import ir.mobilemaster.newscompose.domain.usecases.SaveAppEntry
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager),
    )

}