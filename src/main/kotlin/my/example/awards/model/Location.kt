package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Location {
    @Column(name = "city")
    var city: String? = null

    @Column(name = "stadium")
    var stadium: String? = null
}
