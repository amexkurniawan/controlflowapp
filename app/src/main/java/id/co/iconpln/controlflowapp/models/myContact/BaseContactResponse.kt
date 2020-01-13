package id.co.iconpln.controlflowapp.models.myContact

data class BaseContactResponse<T>(
    val contacts: List<ContactResponse>
)