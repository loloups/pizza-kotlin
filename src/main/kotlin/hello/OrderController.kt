package hello

import org.springframework.web.bind.annotation.*

@CrossOrigin()
@RestController
class OrderController(private val repository: OrderDao, private val repoMeal: MealDao) {

    @GetMapping("/order")
    fun findAll() = repository.findAll()

    @PostMapping("/order")
    fun addOrder(@RequestBody pizzas: List<Meal> ): Order {
        val pizzaSaved = pizzas.map { pizza -> repoMeal.save(pizza) }
        val orderToCreate = Order(1)
        orderToCreate.pizzas = pizzaSaved
        return repository.save(orderToCreate)
    }
}