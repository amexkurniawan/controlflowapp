package id.co.iconpln.controlflowapp.models.myUser

data class DeleteUserResponse(
    val deleted_user: UserDataResponse,
    val message: String
)