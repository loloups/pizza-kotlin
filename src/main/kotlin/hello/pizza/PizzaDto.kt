package hello.pizza


data class PizzaDto(val name: String, val meals: List<String>, val price: Float) {
    companion object {
        fun toDto(pizza: Pizza): PizzaDto = PizzaDto(
                pizza.name,
                pizza.ingredients.map { it.name },
                pizza.ingredients.map { meal -> meal.price }.reduce{ i, price -> i + price})
    }
}