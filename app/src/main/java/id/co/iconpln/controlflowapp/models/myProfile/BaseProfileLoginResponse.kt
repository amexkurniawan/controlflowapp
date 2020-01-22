package id.co.iconpln.controlflowapp.models.myProfile

data class BaseProfileLoginResponse<T>(
    val `data`: ProfileLoginResponse,
    val messages: List<String>,
    val status: Int,
    val success: Boolean
)