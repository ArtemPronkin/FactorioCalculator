import com.fasterxml.jackson.databind.ObjectMapper

abstract class Item(
    val productionTime: Float,
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


fun calculateAll(
    list: List<Item>,
    summary: MutableMap<String, Summary>,
    baseComponentName: String
): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()

    list.forEach { component ->
        val simpleNameComponent = component::class.simpleName!!
        result.put(
            simpleNameComponent,
            Result(0F, 0F, formula = mutableMapOf(), summary = mutableMapOf())
        )

        if (summary.contains(simpleNameComponent).not()) {
            summary[simpleNameComponent] = Summary(0F, 0F)
        }
        summary[simpleNameComponent]!!.countInSec += component.count
        summary[simpleNameComponent]!!.countAutomat =
        countAutoMate(summary[simpleNameComponent]!!.countInSec, component.productionTime,component.automatSpeed)

        result[simpleNameComponent]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(component.formula, summary, baseComponentName)
            it.countAutomat = countAutoMate(it.countInSec, component.productionTime,component.automatSpeed)
        }
    }
    return result;
}

fun calculateWithSummary(list: List<Item>): MutableMap<String, Result> {
    val result = mutableMapOf<String, Result>()

    list.forEach { component ->
        val simpleNameComponent = component::class.simpleName!!
        result[simpleNameComponent] = Result(0F, 0F, formula = mutableMapOf(), mutableMapOf<String, Summary>())
        result[simpleNameComponent]!!.also {
            it.countInSec += component.count
            it.formula = calculateAll(
                component.formula,
                result[simpleNameComponent]!!.summary,
                simpleNameComponent
            )
            it.countAutomat = countAutoMate(it.countInSec, component.productionTime,component.automatSpeed)
        }
    }

    return result;
}

fun countAutoMate(count: Float, productionTime: Float, speedAutomat: Float): Float =
    count.div(1 / productionTime) * (1/speedAutomat)

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