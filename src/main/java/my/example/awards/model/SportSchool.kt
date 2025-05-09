package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "sport_school")
class SportSchool {
    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null

    @Column(name = "title")
    var title: String? = null
}
