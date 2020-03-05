package kr.co.unioncomm.petid.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kr.co.unioncomm.petid.data.MainRepository
import javax.inject.Inject

class MainViewModel @Inject
constructor(private val mainRepository: MainRepository) : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val currentPosition: String
        get() = mainRepository.psosition

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
