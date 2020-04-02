package kr.co.unioncomm.petid.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kr.co.unioncomm.petid.App
import kr.co.unioncomm.petid.data.MainRepository
import javax.inject.Inject

class MainViewModel @Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {
    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var currentBitmap: MutableLiveData<Bitmap>? = MutableLiveData()
    var message: MutableLiveData<String> = MutableLiveData()

    val currentPosition: String
        get() = mainRepository.psosition

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        currentBitmap?.value?.recycle()
    }
}
