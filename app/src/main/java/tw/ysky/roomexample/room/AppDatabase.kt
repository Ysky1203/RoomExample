package tw.ysky.roomexample.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Actor::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun actorDao(): ActorDao

    companion object {
        //Add column : gender
        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user " + "ADD COLUMN gender TEXT")
            }
        }
    }

}