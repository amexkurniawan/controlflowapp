package id.co.iconpln.controlflowapp.models.myProfile

data class BaseMyProfileResponse(
    val `data`: Data,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)