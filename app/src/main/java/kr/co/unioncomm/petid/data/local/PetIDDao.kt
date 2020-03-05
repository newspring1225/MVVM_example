package kr.co.unioncomm.petid.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import kr.co.unioncomm.petid.data.model.Account

@Dao
interface PetIDDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAccountResult(user: Account)

    @Query("SELECT * FROM accountResult LIMIT 1")
    fun loadAccountResult(): Flowable<Account>
}
