package my.example.awards.model

import jakarta.persistence.*

@Entity
@Table(name = "license")
@NamedQueries(value = [
    NamedQuery(
        name = "JPQL.License.findByLicenseNumber103",
        query = "select new my.example.awards.model.dto.LicenseDTO(licenseNumber, licenseInfo.serialNumber, licenseInfo.description) " +
                "from License l where l.licenseInfo.serialNumber = 103"
    )
])
@NamedNativeQueries(value = [
    NamedNativeQuery(
        name = "SQL.License.findByLicenseNumber102",
        query = "select * from license where sn = 102",
        resultClass = License::class
    )
])
class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "license_number")
    var licenseNumber: String? = null

    @Embedded
    var licenseInfo: LicenseInfo? = null

    override fun toString(): String {
        return "License(id=$id, number=$licenseNumber, sn=${licenseInfo?.serialNumber}, description=${licenseInfo?.description})"
    }
}
