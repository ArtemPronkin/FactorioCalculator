
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
        GreenElectricPlate(count*1)
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

data class GreenElectricPlate(override val count : Float) : Item(productionTime = 0.5F ,
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

data class PurpleBootle(override val count : Float) : Item(productionTime = 21F/3F ,
    count = count,
    formula = listOf(
        Rail(count*30/3),
        ElectricFurnance(count*1/3),
        ProductivityModule(count*1/3)
    )
)

data class Rail(override val count : Float) : Item(productionTime = 0.5F/2F ,
    count = count,
    formula = listOf(
        Stone(count*1/2),
        SteelPlate(count*1/2),
        IronStick(count*1/2)
    )
)

data class Stone(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
    )
)
data class Coal(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
    )
)

data class SteelPlate(override val count : Float) : Item(productionTime = 16F ,
    count = count,
    formula = listOf(
        Iron(count*5),
    )
){
    override val automatSpeed: Float = 2F
}

data class IronStick(override val count : Float) : Item(productionTime = 0.5F/2F ,
    count = count,
    formula = listOf(
        Iron(count*1/2),
    )
)

data class ElectricFurnance(override val count : Float) : Item(productionTime = 5F ,
    count = count,
    formula = listOf(
        SteelPlate(count*10),
        RedElecticPlate(count*5),
        StoneBlock(count*10)
    )
)

data class RedElecticPlate(override val count : Float) : Item(productionTime = 6F ,
    count = count,
    formula = listOf(
        Plastic(count*2),
        GreenElectricPlate(count*2),
        CooperCable(count*4)
    )
)

data class Plastic(override val count : Float) : Item(productionTime = 1F/2 ,
    count = count,
    formula = listOf(
        Coal(count*1/2),
        PetroliumGas(count*20/2),
    )
)

{
    override val automatSpeed: Float = 1F

}data class PetroliumGas(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
    )
)

{
    override val automatSpeed: Float = 1F
}


data class StoneBlock(override val count : Float) : Item(productionTime = 3.2F ,
    count = count,
    formula = listOf(
        Stone(count*2),
    )
)
{
    override val automatSpeed: Float = 2F
}

data class ProductivityModule(override val count : Float) : Item(productionTime = 15F ,
    count = count,
    formula = listOf(
        RedElecticPlate(count*5),
        GreenElectricPlate(count*5),
    )
)