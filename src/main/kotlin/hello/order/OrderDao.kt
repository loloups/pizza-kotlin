package hello.order

import org.springframework.data.repository.CrudRepository

interface OrderDao : CrudRepository<Order, Long>