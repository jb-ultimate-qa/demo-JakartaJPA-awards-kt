package my.example.awards.model.dto

class LicenseDTO(
    private val licenseNumber: String?,
    private val serialNumber: Integer?,
    private val description: String?
) {
    override fun toString(): String {
        return "LicenseDTO(licenseNumber=$licenseNumber, serialNumber=$serialNumber, description=$description)"
    }
}
