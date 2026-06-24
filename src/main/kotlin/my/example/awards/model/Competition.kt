package my.example.awards.model

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "competition")
class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "title")
    var title: String? = null

    @Enumerated
    @Column(name = "competition_level")
    var competitionLevel: CompetitionLevel? = null

    @Embedded
    var location: Location? = null

    @ManyToOne
    @JoinColumn(name = "referee_id")
    var referee: Referee? = null

    @ManyToOne
    @JoinColumn(name = "first_player_id")
    var firstPlayer: Player? = null

    @ManyToOne
    @JoinColumn(name = "second_player_id")
    var secondPlayer: Player? = null
}
