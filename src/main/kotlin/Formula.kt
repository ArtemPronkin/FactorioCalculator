
data class RedBootles(override val count : Float) : Item(productionTime = 5F ,
    count = count,
    formula = listOf(
        GearWheel(count*1),
        Cooper(count*1)
    )
)

data class GearWheel(override val count : Float) : Item(productionTime = 0.5F,
count = count,
formula = listOf(
Iron(count*2)
))

data class Iron(override val count : Float) : Item(productionTime = 0F,
    count = count,
    formula = listOf()
)

data class Cooper(override val count : Float) : Item(productionTime = 0F,
    count = count,
    formula = listOf()
)

data class Inserter(override val count : Float) : Item(productionTime = 0.5F ,
    count = count,
    formula = listOf(
        Iron(count*1),
        GearWheel(count*1),
        GreenElectric(count*1)
    )
)

data class TransportBelt(override val count : Float) : Item(productionTime = 0.5F ,
    count = count,
    formula = listOf(
        GearWheel(count*1),
        Iron(count*1)
    )
)

data class CooperCable(override val count : Float) : Item(productionTime = 0.25F ,
    count = count,
    formula = listOf(
        Cooper(count/2),

    )
)

data class GreenElectric(override val count : Float) : Item(productionTime = 0.5F ,
    count = count,
    formula = listOf(
        CooperCable(count*3),
        Iron(count*1)
    )
)

data class GreenBootle(override val count : Float) : Item(productionTime = 6F ,
    count = count,
    formula = listOf(
        TransportBelt(count*1),
        Inserter(count*1)
    )
)