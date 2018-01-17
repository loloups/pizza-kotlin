package hello.pizza

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin()
@RestController
class PizzaController(private val repoPizza: PizzaDao) {

    @GetMapping("/pizza")
    fun findAll() = repoPizza.findAll()
}
