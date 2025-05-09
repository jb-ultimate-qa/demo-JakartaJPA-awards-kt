package my.example.awards.model

import jakarta.persistence.*

@Entity
@Table(name = "player")
class Player : Person() {
    @Column(name = "rating")
    var rating: Int? = null

    @OneToMany(mappedBy = "winner", orphanRemoval = true)
    var awards: MutableSet<Award?>? = LinkedHashSet<Award?>()

    @ManyToMany
    @JoinTable(
        name = "player_sport_school",
        joinColumns = [JoinColumn(name = "player_id")],
        inverseJoinColumns = [JoinColumn(name = "sport_school_id")]
    )
    var sportSchools: MutableSet<SportSchool?>? = LinkedHashSet<SportSchool?>()
}
