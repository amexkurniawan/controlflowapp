package id.co.iconpln.controlflowapp.models.myProfile

data class BaseProfileResponse<T>(
    val `data`: ProfileResponse,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)