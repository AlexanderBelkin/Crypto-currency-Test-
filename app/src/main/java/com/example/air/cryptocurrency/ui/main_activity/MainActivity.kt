package com.example.air.cryptocurrency.ui.main_activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.air.cryptocurrency.R
import com.example.air.cryptocurrency.ui.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView {

    @Inject
    lateinit var presenter : MainActivityPresenter<IMainActivityView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActivityComponents().inject(this)
        presenter.onAttach(this)
    }
}
