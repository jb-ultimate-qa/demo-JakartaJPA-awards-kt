package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class Person {
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Column(name = "first_name")
    var fullName: String? = null
}
