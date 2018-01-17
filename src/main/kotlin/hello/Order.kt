package hello

import javax.persistence.*

@Entity(name = "orders")
data class Order(
		val numberTable: Int,
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		val id: Long = -1){
    @ManyToMany
    @JoinTable(name = "meal_order", joinColumns = arrayOf(JoinColumn(name ="order_id", referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "meal_id", referencedColumnName = "id")))
    lateinit var pizzas: List<Meal>

}
