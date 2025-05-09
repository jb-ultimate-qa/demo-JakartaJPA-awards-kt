package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "award")
class Award {
    @Id
    @Column(name = "id", nullable = false)
    var id: Int? = null

    @Column(name = "year_", nullable = false)
    var year: Short? = null

    @Column(name = "title", nullable = false)
    var title: String? = null

    @ManyToOne
    @JoinColumn(name = "winner_id")
    var winner: Player? = null

    override fun toString(): String {
        return javaClass.getSimpleName() + " (" + year + " - " + title + ")"
    }
}
