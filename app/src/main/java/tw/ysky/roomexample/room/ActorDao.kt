package tw.ysky.roomexample.room

import androidx.room.*

/**
 * CURD interface.
 * https://developer.android.com/reference/android/arch/persistence/room/OnConflictStrategy
 */

@Dao
interface ActorDao {
    @Query("SELECT * FROM actor")
    fun getAll(): List<Actor>

    @Query("SELECT * FROM actor WHERE uid IN (:actorIds)")
    fun loadAllByIds(actorIds: IntArray): List<Actor>

    @Query("SELECT * FROM actor WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Actor

    @Insert
    fun insertAll(vararg actors: Actor)

    @Delete
    fun delete(actor: Actor)
}