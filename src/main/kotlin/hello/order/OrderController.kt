package hello.order

import hello.meal.MealDao
import hello.pizza.Pizza
import hello.pizza.PizzaDao
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin()
@RestController
class OrderController(private val repository: OrderDao, private val repoMeal: MealDao, private val repoPizza: PizzaDao) {

    @GetMapping("/order")
    fun findAll(): List<OrderDto> = repository.findAll().map { OrderDto.toDto(it) }

    @PostMapping("/order")
    fun addOrder(@RequestBody order: OrderCreation): OrderDto {
        val pizzaSaved: List<Optional<Pizza>> = order.pizzas.map { pizzaId ->
            repoPizza.findById(pizzaId)
        }

        val orderToCreate = Order(order.nbTable)
        pizzaSaved.forEach { pizza -> pizza.ifPresent { p -> orderToCreate.pizzas.add(p) } }
        return OrderDto.toDto(repository.save(orderToCreate))
    }
}