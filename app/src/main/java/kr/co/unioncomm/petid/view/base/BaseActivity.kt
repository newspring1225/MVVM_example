package kr.co.unioncomm.petid.view.base

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import kr.co.unioncomm.petid.util.Trace
import java.lang.ref.WeakReference
import javax.inject.Inject

abstract class BaseActivity<V : ViewModel, D : ViewDataBinding> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: V
    protected lateinit var dataBinding: D

    @get:LayoutRes
    protected abstract val layoutRes: Int
    protected lateinit var handler : WeakHandler

    protected abstract fun getViewModel(): Class<V>

    protected abstract fun initLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())

        handler = WeakHandler(this)
        Trace.d("onCreate")
    }

    inner class WeakHandler constructor(act: BaseActivity<*, *>) : Handler() {
        private val mWeakActivity: WeakReference<BaseActivity<*, *>> = WeakReference(act)

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val activity = mWeakActivity.get()
            activity?.handleMessage(msg)
        }
    }

    open fun handleMessage(msg: Message) {
        when (msg.what) {

        }
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

