package id.co.iconpln.controlflowapp.models.myUser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDataResponse(
    val address: String,
    val id: Int,
    val name: String,
    val phone: String
): Parcelable