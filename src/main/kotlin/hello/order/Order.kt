package hello.order

import hello.pizza.Pizza
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity(name = "orders")
class Order(nbTable: Int) {

    var numberTable: Int = nbTable
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1

    @ManyToMany
    @JoinTable(name = "order_pizza", joinColumns = arrayOf(JoinColumn(name ="order_id", referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "meal_id", referencedColumnName = "id")))
    var pizzas: MutableList<Pizza> = mutableListOf()


}
