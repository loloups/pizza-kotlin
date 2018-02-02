package hello.pizza


data class PizzaDto(val id: Long, val name: String, val ingredients: List<String>, val price: Double) {
    companion object {
        fun toDto(pizza: Pizza): PizzaDto = PizzaDto(
                pizza.id,
                pizza.name,
                pizza.ingredients.map { it.name },
                pizza.ingredients.sumByDouble{ meal -> meal.price.toDouble()})

        fun fromDto(pizzaDto: PizzaDto): Pizza {
            val pizza = Pizza(pizzaDto.name, pizzaDto.price.toLong())
            pizza.ingredients = listOf()
            pizzaDto.ingredients.forEach{ ingredient ->

            }
            return pizza
        }
    }
}