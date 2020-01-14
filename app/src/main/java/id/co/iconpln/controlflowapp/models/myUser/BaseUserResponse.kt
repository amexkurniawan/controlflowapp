package id.co.iconpln.controlflowapp.models.myUser

data class BaseUserResponse(
    val count: Int,
    val data: List<UserDataResponse>,
    val total: Int
)