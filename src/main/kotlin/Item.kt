import com.fasterxml.jackson.databind.ObjectMapper

abstract class Item(
    val speed: Float,
    open val count: Float,
    val formula: List<Item>
) {


}

data class Result(
    var countInSec: Float,
    var countAutomat: Float,
    var formula: MutableMap<String, Result>,
    var svodka: MutableMap<String, Result>,

)

data class Svodka(
    var countInSec: Float,
    var countAutomat: Float,
    )


fun calculateAll(list: List<Item>, summary : MutableMap<String, Result> , svodka : MutableMap<String, Result> , baseComponentName: String ): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()
    list.forEach {result.put(it::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf(), svodka = mutableMapOf())) }

    list.forEach { component ->
        if (svodka.contains(component::class.simpleName).not()){
            svodka[component::class.simpleName!!] = Result(0F, 0F, formula = mutableMapOf(), svodka = mutableMapOf())
            svodka[component.javaClass.simpleName]!!.countInSec += component.count
            svodka[component.javaClass.simpleName]!!.countAutomat = countAutoMate(svodka[component.javaClass.simpleName]!!.countInSec,component.speed)
        }else {
            svodka[component.javaClass.simpleName]!!.countInSec += component.count
            svodka[component.javaClass.simpleName]!!.countAutomat = countAutoMate(svodka[component.javaClass.simpleName]!!.countInSec,component.speed)}
    }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula , summary,svodka, baseComponentName )
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
    list.forEach { result.put(it::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf(),mutableMapOf<String, Result>() )) }
    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula,result,result[component.javaClass.simpleName]!!.svodka,component.javaClass.simpleName,)
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