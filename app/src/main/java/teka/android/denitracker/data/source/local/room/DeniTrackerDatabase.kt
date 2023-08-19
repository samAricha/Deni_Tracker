package teka.android.denitracker.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import teka.android.denitracker.data.source.local.room.models.Credit
import teka.android.denitracker.data.source.local.room.models.Debit

@Database(
    entities = [Credit::class, Debit::class],
    version = 1,
    exportSchema = false
)
abstract class DeniTrackerDatabase: RoomDatabase() {

    abstract fun debitCreditDao(): DebitCreditDao

    companion object{
        @Volatile
        var INSTANCE: DeniTrackerDatabase? = null
        fun getDatabase(context: Context): DeniTrackerDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    DeniTrackerDatabase::class.java,
                    "deni_tracker_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }



}