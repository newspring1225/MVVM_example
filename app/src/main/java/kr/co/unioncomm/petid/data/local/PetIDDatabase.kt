package kr.co.unioncomm.petid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.co.unioncomm.petid.data.model.Account
import kr.co.unioncomm.petid.data.model.Converters

@Database(entities = [Account::class], version = 1)
@TypeConverters(Converters::class)
abstract class PetIDDatabase : RoomDatabase() {
    abstract fun petIDDatabase(): PetIDDao
}