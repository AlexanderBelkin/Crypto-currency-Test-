package com.example.air.cryptocurrency.di.component

import com.example.air.cryptocurrency.ui.main_activity.MainActivity
import com.example.air.cryptocurrency.di.ActivityScope
import com.example.air.cryptocurrency.di.modul.ActivityModule
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class) , modules = arrayOf(ActivityModule::class))
interface ActivityComponent  {

    fun inject(activity: MainActivity)

}