package id.co.iconpln.controlflowapp.models.myProfile

data class ProfileLoginResponse(
    val customer: ProfileResponse,
    val token: String
)