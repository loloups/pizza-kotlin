package hello.pizza

import org.springframework.data.repository.CrudRepository

interface PizzaDao : CrudRepository<Pizza, Long>
