package kr.co.unioncomm.petid.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.co.unioncomm.petid.view.EnrollActivity
import kr.co.unioncomm.petid.view.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun mainAcitivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun enrollActivity(): EnrollActivity
}
