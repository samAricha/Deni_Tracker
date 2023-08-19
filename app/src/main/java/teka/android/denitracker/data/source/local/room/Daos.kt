package teka.android.denitracker.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import teka.android.denitracker.data.source.local.room.models.Credit
import teka.android.denitracker.data.source.local.room.models.Debit


@Dao
interface DebitCreditDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCredit(credit: Credit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDebit(debit: Debit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCredit(credit: Credit)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateDebit(debit: Debit)


    @Query("SELECT * FROM credits")
    fun getAllCredits(): Flow<List<Credit>>

    @Query("SELECT * FROM debits")
    fun getAllDebits(): Flow<List<Debit>>


}