package id.co.iconpln.controlflowapp.myContact

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileUser(
    var userToken: String? = null
): Parcelable