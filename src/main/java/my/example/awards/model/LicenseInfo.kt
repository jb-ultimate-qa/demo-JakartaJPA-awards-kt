package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
@JvmRecord
data class LicenseInfo(
    @field:Column(name = "sn") val serialNumber: Int?,
    @field:Column(name = "descr") val description: String?
)
