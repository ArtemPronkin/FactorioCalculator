import com.fasterxml.jackson.databind.ObjectMapper

abstract class Item(
    val time: Float,
    open val count: Float,
    val formula: List<Item>
) {
    open val automatSpeed: Float = 0.75f
}

data class Result(
    var countInSec: Float,
    var countAutomat: Float,
    var formula: MutableMap<String, Result>,
    var summary: MutableMap<String, Summary>,

    )

data class Summary(
    var countInSec: Float,
    var countAutomat: Float,
    )


fun calculateAll(list: List<Item>, summary : MutableMap<String, Result> , svodka : MutableMap<String, Summary> , baseComponentName: String ): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()

    list.forEach {result.put(it::class.simpleName!!, Result(0F, 0F, formula = mutableMapOf(), summary = mutableMapOf())) }

    list.forEach { component ->
        val simpleNameComponent = component::class.simpleName!!
        if (svodka.contains(simpleNameComponent).not()){
           val default =  Summary(0F, 0F)
               svodka[simpleNameComponent] = Summary(0F, 0F)
            svodka[simpleNameComponent]!!.countInSec += component.count
            svodka[simpleNameComponent]!!.countAutomat = countAutoMate(svodka[simpleNameComponent]!!.countInSec,component.time)
        }else {
            svodka[simpleNameComponent]!!.countInSec += component.count
            svodka[simpleNameComponent]!!.countAutomat = countAutoMate(svodka[simpleNameComponent]!!.countInSec,component.time)}
    }


    list.forEach { component ->
        result[component::class.simpleName!!] = result[component::class.simpleName]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula , summary,svodka, baseComponentName )
            it.countAutomat = countAutoMate(it.countInSec, component.time)
        }
    }
    return result;
}

fun calculateWithSummary(list: List<Item>): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()

    list.forEach {
        result[it::class.simpleName!!] = Result(0F, 0F, formula = mutableMapOf(),mutableMapOf<String, Summary>() )
    }

    list.forEach { component ->
        val simpleNameComponent = component::class.simpleName!!
        result[simpleNameComponent] = result[simpleNameComponent]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(
                component.formula,
                result,result[simpleNameComponent]!!.summary,
                simpleNameComponent)
            it.countAutomat = countAutoMate(it.countInSec, component.time)
        }
    }

    return result;
}

fun countAutoMate(count: Float, speed: Float): Float = count.div(1 / speed)
fun main() {
    val map = calculateWithSummary(
        listOf(
            RedBootles(2F),
            GreenBootle(2F)
        )
    )
    println(map.map { "*************** \nЧто хотим : " + it.key + it.value.toString() + "\n\n***************" })
    val result = ObjectMapper().writeValueAsString(map)
    println(result)
}