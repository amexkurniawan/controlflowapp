package id.co.iconpln.controlflowapp.models.myProfile

data class ProfileRegisterResponse<T>(
    val `data`: ProfileResponse,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)