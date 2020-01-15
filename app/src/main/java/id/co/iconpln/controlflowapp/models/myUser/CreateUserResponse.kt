package id.co.iconpln.controlflowapp.models.myUser

data class CreateUserResponse(
    val created_users: UserDataResponse,
    val message: String
)