package hello

import hello.meal.Meal
import hello.meal.MealDao
import hello.order.Order
import hello.order.OrderDao
import hello.pizza.Pizza
import hello.pizza.PizzaDao
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

	private val log = LoggerFactory.getLogger(Application::class.java)

	@Bean
	fun init(repoMeal: MealDao, repoOrder: OrderDao, pizzaDao: PizzaDao) = CommandLineRunner {
			// save a couple of customers
			var olive = repoMeal.save(Meal("Olive", 1f))
			var cheese = repoMeal.save(Meal("Cheese", 3f))
			var peperoni = Pizza("Peperoni")
			peperoni.ingredients = listOf(olive, cheese)
			val savedMeal = pizzaDao.save(peperoni)

			val order = Order(5)

			order.pizzas = mutableListOf(savedMeal)
			repoOrder.save(order)
			// fetch all customers
			log.info("Customers found with findAll():")
			log.info("-------------------------------")
			repoMeal.findAll().forEach { log.info(it.toString()) }
			log.info("")

			// fetch an individual customer by ID
			val customer = repoMeal.findById(1L)
			customer.ifPresent {
				log.info("Customer found with findOne(1L):")
				log.info("--------------------------------")
				log.info(it.toString())
				log.info("")
			}

	}

}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
