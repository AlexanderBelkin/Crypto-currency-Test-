package com.example.air.cryptocurrency.ui.main_activity

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.air.cryptocurrency.R
import com.example.air.cryptocurrency.adapter.CurrencyAdapter
import com.example.air.cryptocurrency.adapter.CurrencyHolder
import com.example.air.cryptocurrency.model.ArrayCurrency
import com.example.air.cryptocurrency.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), IMainActivityView, SwipeRefreshLayout.OnRefreshListener, CurrencyHolder.RangCallback {

    val currencyAdapter = CurrencyAdapter(this)

    @Inject
    lateinit var presenter : MainActivityPresenter<IMainActivityView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActivityComponents().inject(this)
        presenter.onAttach(this)
        presenter.getCurrencyList()
        swipeRefreshLayout.setOnRefreshListener(this)
        swipeRefreshLayout.isRefreshing = true
        recycler_currency.layoutManager = LinearLayoutManager(this)
        recycler_currency.adapter = currencyAdapter
    }

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = true
        presenter.getCurrencyList()
    }

    override fun Success() {
        swipeRefreshLayout.isRefreshing = false
        currencyAdapter.setData(ArrayCurrency.listCurrency)
        currencyAdapter.notifyDataSetChanged()
    }

    override fun onError(errorString: String) {
        swipeRefreshLayout.isRefreshing = false
        super.onError(errorString)
    }

    override fun getRang(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()

        return if (id == R.id.action_search) {
            true
        } else if(id == R.id.action_setting){
            true
        } else super.onOptionsItemSelected(item)

    }

}
