package hello.pizza


import hello.meal.Meal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
data class Pizza(
        val name: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0) {
    @ManyToMany
    @JoinTable(name = "meal_pizza", joinColumns = arrayOf(JoinColumn(referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(referencedColumnName = "id")))
    lateinit var ingredients: List<Meal>
}