package hello.meal

import org.springframework.data.repository.CrudRepository

interface MealDao : CrudRepository<Meal, Long>