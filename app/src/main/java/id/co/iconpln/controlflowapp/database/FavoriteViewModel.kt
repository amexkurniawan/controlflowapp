package id.co.iconpln.controlflowapp.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private  val repository: FavoriteDatabaseRepository
    private val allFavoriteUsers: LiveData<List<FavoriteUser>>

    init {
        val favDatabaseDao = FavoriteDatabase.getInstance(application).favoriteDatabaseDao
        repository = FavoriteDatabaseRepository(favDatabaseDao)
        allFavoriteUsers = repository.allFavUsers
    }

    fun getAllFavoriteUsers(): LiveData<List<FavoriteUser>>{
        return allFavoriteUsers
    }

    fun getUser(id: Int): LiveData<FavoriteUser> {
        return repository.getUser(id)
    }

    fun insertUser(user: FavoriteUser){
        // using courotine
        GlobalScope.launch {
            repository.insertUser(user)
            Log.d("@@@Ame", "User ${user.userName} id ${user.userId}  -- INSERTED")
        }
    }

    fun updateUser(user: FavoriteUser){
        GlobalScope.launch {
            repository.updateUser(user)
            Log.d("@@@Ame", "User ${user.userName}, ${user.userId}  -- UPDATED")
        }
    }

    fun deleteUser(userId: Int){
        GlobalScope.launch {
            repository.deleteUser(userId)
            Log.d("@@@Ame", "User -- DELETED")
        }
    }
}