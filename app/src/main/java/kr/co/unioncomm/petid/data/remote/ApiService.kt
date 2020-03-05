package kr.co.unioncomm.petid.data.remote

import io.reactivex.Flowable
import retrofit2.http.*

interface ApiService {

    @get:GET("positions")
    val positions: Flowable<Int>
}
