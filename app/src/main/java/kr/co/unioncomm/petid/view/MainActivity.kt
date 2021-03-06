package kr.co.unioncomm.petid.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kr.co.unioncomm.petid.R
import kr.co.unioncomm.petid.databinding.ActivityMainBinding
import kr.co.unioncomm.petid.util.Trace
import kr.co.unioncomm.petid.view.base.BaseActivity
import kr.co.unioncomm.petid.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_main

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

    }

    fun onClickEnroll(view:View){
        startActivity(Intent(this,EnrollActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        })
    }

    fun onClickMatching(view:View){
        Toast.makeText(this,"서비스 개발 중입니다.",Toast.LENGTH_SHORT).show()
    }
}
