package hello.meal

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Meal(
        val name: String,
        val price: Float,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0)
