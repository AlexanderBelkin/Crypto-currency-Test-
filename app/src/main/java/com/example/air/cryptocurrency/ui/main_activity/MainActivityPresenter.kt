package com.example.air.cryptocurrency.ui.main_activity

import com.example.air.cryptocurrency.data.IDataManager
import com.example.air.cryptocurrency.ui.base.BasePresenter
import com.example.air.cryptocurrency.utils.rx.ISchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityPresenter <V : IMainActivityView> @Inject
constructor(schedulerProvider: ISchedulerProvider,
            compositeDisposable: CompositeDisposable,
            dataManager: IDataManager) : BasePresenter<V>(schedulerProvider , compositeDisposable , dataManager) , IMainActivityPresenter<V> {

}