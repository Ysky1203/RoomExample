package tw.ysky.roomexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tw.ysky.roomexample.room.DBHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = DBHelper.createDataBase(this).actorDao()

        GlobalScope.launch(Dispatchers.IO) {

//            dao.insertAll(Actor("Robert", "De Niro", "male"))
//            dao.insertAll(Actor("Jack", "Nicholson", "male"))
//            dao.insertAll(Actor("Marlon", "Brando", "male"))
//            dao.insertAll(Actor("Denzel", "Washington", "male"))
//            dao.insertAll(Actor("Katharine", "Hepburn", "female"))

            dao.getAll().forEachIndexed { index, user ->
                println("Actors name = $index , $user")
            }
        }
    }
}