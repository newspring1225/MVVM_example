package kr.co.unioncomm.petid.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kr.co.unioncomm.petid.data.ApiConstants
import kr.co.unioncomm.petid.data.local.PetIDDao
import kr.co.unioncomm.petid.data.local.PetIDDatabase
import kr.co.unioncomm.petid.data.prefs.Preference
import kr.co.unioncomm.petid.data.prefs.PreferencesHelper
import kr.co.unioncomm.petid.data.remote.ApiService
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideAccountDatabase(application: Application): PetIDDatabase {
        return Room.databaseBuilder<PetIDDatabase>(application, PetIDDatabase::class.java, ApiConstants.DB_NAME)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideArticleDao(petIDDatabase: PetIDDatabase): PetIDDao {
        return petIDDatabase.petIDDatabase()
    }

    @Provides
    @Singleton
    internal fun providePreference(preference: Preference): PreferencesHelper {
        return preference
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)
        val logging = HttpLoggingInterceptor { message -> }
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.cookieJar(JavaNetCookieJar(cookieManager))
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.addInterceptor(logging)
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
