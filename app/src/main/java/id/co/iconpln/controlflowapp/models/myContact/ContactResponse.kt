package id.co.iconpln.controlflowapp.models.myContact

data class ContactResponse(
    val address: String,
    val email: String,
    val gender: String,
    val id: String,
    val name: String,
    val phone: PhoneResponse
)