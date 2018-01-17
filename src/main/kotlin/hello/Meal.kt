package hello

import javax.persistence.*

@Entity
data class Meal(
        val name: String,
        val price: Float,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0) {
    @ManyToMany
    @JoinTable(name = "meal_meal", joinColumns = arrayOf(JoinColumn(referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(referencedColumnName = "id")))
    lateinit var ingredients: List<Meal>
}
