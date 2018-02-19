package com.example.air.cryptocurrency.ui.setting_screen

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.MenuItem
import com.example.air.cryptocurrency.R
import com.example.air.cryptocurrency.ui.base.BaseActivity
import com.example.air.cryptocurrency.ui.detail_activity.DetailActivity
import com.example.air.cryptocurrency.ui.main_activity.MainActivity
import com.pixplicity.easyprefs.library.Prefs
import kotlinx.android.synthetic.main.activity_setting.*
import javax.inject.Inject

class SettingActivity : BaseActivity(), ISettingActivityView {

    private val TAG = SettingActivity::class.java.simpleName

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, SettingActivity::class.java)
        }

    }

    @Inject
    lateinit var presenter : SettingActivityPresenter<ISettingActivityView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        getActivityComponents().inject(this)
        presenter.onAttach(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Setting"

        when(Prefs.getString("currency", "USD")){
            "USD" -> usd_btn.setBackgroundColor(Color.BLUE)
            "EUR" -> usd_btn.setBackgroundColor(Color.BLUE)
            "CNY" -> usd_btn.setBackgroundColor(Color.BLUE)
        }

        usd_btn.setOnClickListener({
            presenter.setUsdCurrency()
        })

        eur_btn.setOnClickListener({
            presenter.setEurCurrency()
        })

        cny_btn.setOnClickListener({
            presenter.setCnyCurrency()
        })

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId === android.R.id.home) {
            finishAffinity()
            startActivity(MainActivity.getStartIntent(this))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
        startActivity(MainActivity.getStartIntent(this))
        super.onBackPressed()
    }

}
