package my.example.awards.model

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "referee")
class Referee : Person() {
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "license_id")
    private var license: License? = null

    fun getLicense(): License {
        return license!!
    }

    fun setLicense(license: License) {
        this.license = license
    }

    override fun toString(): String {
        return "Referee " + fullName + " with license number " + license!!.licenseNumber
    }
}
