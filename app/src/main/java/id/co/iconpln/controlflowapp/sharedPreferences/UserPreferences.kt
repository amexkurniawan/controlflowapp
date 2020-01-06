package id.co.iconpln.controlflowapp.sharedPreferences

import android.content.Context

internal class UserPreferences(context: Context){

    companion object{
        private const val PREFS_USER = "user_prefs"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val HANDPHONE = "handphone"
        private const val HAS_READING_HOBBY = "hasReadingHobby"
    }

    private val preferences = context.getSharedPreferences(PREFS_USER, Context.MODE_PRIVATE)
}