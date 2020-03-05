package kr.co.unioncomm.petid.data

import io.reactivex.Flowable
import kr.co.unioncomm.petid.data.local.PetIDDao
import kr.co.unioncomm.petid.data.model.Account
import kr.co.unioncomm.petid.data.prefs.PreferencesHelper
import kr.co.unioncomm.petid.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject
constructor(private val apiService: ApiService, private val petIDDao: PetIDDao, private val preferencesHelper: PreferencesHelper) {

    val psosition: String
        get() = preferencesHelper.position

    fun loadAccoutResult(): Flowable<Account> {
        return petIDDao.loadAccountResult()
    }

    val position: Flowable<Int>
        get() = apiService.positions.doOnNext { }
}
