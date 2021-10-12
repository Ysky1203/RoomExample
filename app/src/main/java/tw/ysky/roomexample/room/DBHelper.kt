package tw.ysky.roomexample.room

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope

object DBHelper {

    private const val DBNAME = "ActorDataBase.db"

    @Volatile
    private var db: AppDatabase? = null

    fun createDataBase(context: Context): AppDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, DBNAME
            ).addMigrations(AppDatabase.MIGRATION_1_2).build()
        }
        return db!!
    }

    fun close() {
        db?.clearAllTables()
        db?.close()
    }
}