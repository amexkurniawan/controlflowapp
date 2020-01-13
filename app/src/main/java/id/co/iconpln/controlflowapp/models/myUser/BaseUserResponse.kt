package id.co.iconpln.controlflowapp.models.myUser

data class BaseUserResponse<T>(
    val count: Int,
    val data: List<UserDataResponse>,
    val total: Int
)