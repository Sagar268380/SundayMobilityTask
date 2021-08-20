package com.elysino.sundaymobilitytask.ui.Activity

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elysino.sundaymobilitytask.R
import com.elysino.sundaymobilitytask.contract.CountryContract
import com.elysino.sundaymobilitytask.model.CountryModel
import com.elysino.sundaymobilitytask.presenter.CountryPresenter
import com.elysino.sundaymobilitytask.ui.Adapter.CountryAdapter
import java.util.ArrayList

class CountryActivity : AppCompatActivity(), CountryContract.View, CountryAdapter.OnItemClickListener {
    var progressDialog: ProgressDialog? = null
    var recyclerView: RecyclerView? = null
    var countryAdapter: CountryAdapter? = null
    var presenter: CountryContract.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpUiElements()
        presenter = CountryPresenter(this)
        presenter?.start()
    }

    private fun setUpUiElements() {
        recyclerView = findViewById(R.id.recycle_view)
        countryAdapter = CountryAdapter(this)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = countryAdapter
        recyclerView?.setHasFixedSize(true)
        countryAdapter?.setOnItemClickListener(this)
    }

    override fun showProgressBar() {
        progressDialog = ProgressDialog(this)
        progressDialog?.show()
        progressDialog?.setCancelable(false)
        progressDialog?.setContentView(R.layout.prgogessdialog)
        progressDialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    override fun hideProgressBar() {
        if (progressDialog != null) {
            progressDialog?.dismiss()
        }
    }

    override fun addItems(arrayList: ArrayList<CountryModel?>) {
        if (countryAdapter != null) {
            countryAdapter?.addItems(arrayList)
        }
    }

    override val isActive: Boolean
        get() = !isFinishing

    override fun moveToNextScreen(intent: Intent?, isFinish: Boolean?) {
        if (isFinish == true) {
            startActivity(intent)
            finish()
        } else {
            startActivity(intent)
        }
    }

    override fun onClick(intent: Intent?, isFinish: Boolean?) {
        moveToNextScreen(intent, isFinish)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.item1) {
            val intent = Intent(this, DynamicRecyclerActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}