package hello.order

import hello.meal.MealDao
import hello.pizza.Pizza
import hello.pizza.PizzaDao
import org.springframework.web.bind.annotation.*

@CrossOrigin()
@RestController
class OrderController(private val repository: OrderDao, private val repoMeal: MealDao, private val repoPizza: PizzaDao) {

    @GetMapping("/order")
    fun findAll(): List<OrderDto> = repository.findAll().map { OrderDto.toDto(it) }

    @PostMapping("/order")
    fun addOrder(@RequestBody pizzas: List<Pizza> ): OrderDto {
        val pizzaSaved = pizzas.map { pizza ->
            repoPizza.save(pizza)
        }
        val orderToCreate = Order(1)
        orderToCreate.pizzas = pizzaSaved
        return OrderDto.toDto(repository.save(orderToCreate))
    }
}