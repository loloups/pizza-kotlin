package hello.order

import hello.pizza.PizzaDto


data class OrderDto(val nbTable: Int, val pizzas: List<PizzaDto>) {
    companion object {
        fun toDto(order: Order): OrderDto = OrderDto(order.numberTable, order.pizzas.map { PizzaDto.toDto(it)})
    }
}