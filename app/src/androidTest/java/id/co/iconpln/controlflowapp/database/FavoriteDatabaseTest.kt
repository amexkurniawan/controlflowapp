package id.co.iconpln.controlflowapp.database

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class FavoriteDatabaseTest{
    private lateinit var favDao: FavoriteDatabaseDao
    private lateinit var db: FavoriteDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, FavoriteDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        favDao = db.favoriteDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetMovie() {
        val user = FavoriteUser()
        favDao.insertUser(user)
        val favoriteMovie = favDao.getFavUser(0)
        assertEquals(favoriteMovie.value?.userName, null)
    }
}