package teka.android.denitracker.data.source.local.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "debits")
data class Debit(
    @ColumnInfo(name = "debit_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String = generateUniqueId(),
    val first_name: String,
    val second_name: String? = null,
    val email: String? = null,
    val phone: String,
    val attended: Boolean = false,
    var isBackedUp: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    companion object {
        private fun generateUniqueId(): String {
            return UUID.randomUUID().toString()
        }
    }
}


@Entity(tableName = "credits")
data class Credit(
    @ColumnInfo(name = "credit_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val uuid: String = generateUniqueId(),
    val first_name: String,
    val second_name: String? = null,
    val email: String? = null,
    val phone: String,
    val attended: Boolean = false,
    var isBackedUp: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    companion object {
        private fun generateUniqueId(): String {
            return UUID.randomUUID().toString()
        }
    }
}