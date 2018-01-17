package hello.meal

import org.springframework.web.bind.annotation.*


@CrossOrigin()
@RestController
class MealController(private val repoMeal: MealDao) {

    @GetMapping("/meal")
    fun findAll() = repoMeal.findAll()
}