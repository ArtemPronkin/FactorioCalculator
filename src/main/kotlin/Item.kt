import com.fasterxml.jackson.databind.ObjectMapper

abstract class Item(
    val speed: Float,
    open val count: Float,
    val formula: List<Item>
) {


}

class Result(
    var countInSec: Float,
    var countAutomat: Float,
    var formula: MutableMap<String, Result>
) {
    override fun toString(): String {
        return " : $countInSec Шт/Cек, $countAutomat автоматов, Что нужно : =$formula \n"
    }
}

fun calculateAll(list: List<Item>, summary : MutableMap<String, Result> ): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()
    list.forEach {result.put(it::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf())) }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula , summary)
        }
    }
    list.forEach { component ->
        if (summary.contains(component::class.simpleName).not()){
            result.put(component::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf()))
        }
    }
    list.forEach { component ->
        summary[component::class.simpleName!!] = summary[component::class.simpleName]!!
            .also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula , summary)
        }
    }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countAutomat = countAutoMate(it.countInSec, component.speed)
        }
    }
    return result;
}

fun calculateSummary(list: List<Item>): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()
    list.forEach { result.put(it::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf())) }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula,result)
        }
    }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countAutomat = countAutoMate(it.countInSec, component.speed)
        }
    }
    return result;
}

fun countAutoMate(count: Float, speed: Float): Float = count.div(1 / speed)
fun main() {
    val map = calculateSummary(
        listOf(
            RedBootles(2F),
            GreenBootle(2F)
        )
    )
    println(map.map { "*************** \nЧто хотим : " + it.key + it.value.toString() + "\n\n***************" })
    val result = ObjectMapper().writeValueAsString(map)
    println(result)
}