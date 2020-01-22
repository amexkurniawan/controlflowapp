package id.co.iconpln.controlflowapp.myProfile

import android.content.Context
import id.co.iconpln.controlflowapp.myContact.ProfileUser

internal class ProfileUserPreference(context: Context) {

    companion object{
        private const val PREFS_PROFILE_USER = "profile_user_prefs"
        private const val TOKEN = "token"
    }

    private val preferences = context.getSharedPreferences(PREFS_PROFILE_USER, Context.MODE_PRIVATE)

    fun setProfileUser(value: ProfileUser){
        val editor = preferences.edit()
        editor.putString(TOKEN, value.userToken)
        editor.apply()
    }

    fun getProfileUser(): ProfileUser {
        val model = ProfileUser()
        model.userToken = preferences.getString(TOKEN, "")
        return model
    }

    fun removeProfileUser(value: ProfileUser){
        val editor = preferences.edit()
        editor.remove(TOKEN)
        editor.apply()
    }

}