package teka.android.denitracker.domain.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import teka.android.denitracker.data.repository.MyDataStoreRepository
import teka.android.denitracker.ui.presentation.splash_screen.presentation.SplashViewModel
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DeniTrackerDiModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = MyDataStoreRepository(context = context)

    @Provides
    @Singleton
    fun provideSplashViewModel(repository: MyDataStoreRepository): SplashViewModel {
        return SplashViewModel(repository)
    }


}