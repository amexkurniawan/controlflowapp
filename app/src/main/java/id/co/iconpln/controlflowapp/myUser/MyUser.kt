package id.co.iconpln.controlflowapp.myUser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyUser (
    var id: String? = "0",
    var name: String? = null,
    var address: String? = null,
    var mobile: String? = null
): Parcelable