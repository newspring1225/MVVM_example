package kr.co.unioncomm.petid

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import kr.co.unioncomm.petid.di.components.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    companion object{
        lateinit var context : Context
    }

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        context = this
        initializeComponent()
    }

    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingInjector
    }
}