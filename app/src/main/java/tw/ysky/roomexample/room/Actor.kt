package tw.ysky.roomexample.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Actor(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "gender") val gender: String?
){
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}