package kr.co.unioncomm.petid.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_enroll.*
import kr.co.unioncomm.petid.R
import kr.co.unioncomm.petid.databinding.ActivityEnrollBinding
import kr.co.unioncomm.petid.databinding.ActivityMainBinding
import kr.co.unioncomm.petid.util.Trace
import kr.co.unioncomm.petid.view.base.BaseActivity
import kr.co.unioncomm.petid.viewmodel.MainViewModel

class EnrollActivity : BaseActivity<MainViewModel, ActivityEnrollBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_enroll

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Trace.d("onCreate")
        setToolbar()
        initLiveData()
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initLiveData() {
        Trace.d("initLiveData")
    }

    private fun setToolbar() {
        toolbar.title = getString(R.string.enroll)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
