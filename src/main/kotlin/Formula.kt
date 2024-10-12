
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

data class BlueBootle(override val count : Float) : Item(productionTime = 24F/2F ,
    count = count,
    formula = listOf(
        RedElecticPlate(count*3/2),
        Sulfur(count*1/2),
        Engine(count*2/2),
    )
)

data class Engine(override val count : Float) : Item(productionTime = 10F ,
    count = count,
    formula = listOf(
        SteelPlate(count*1),
        GearWheel(count*1),
        Pipe(count*2),
    )
)

data class Pipe(override val count : Float) : Item(productionTime = 0.5F ,
    count = count,
    formula = listOf(
        Iron(count*1),
    )
)

data class Sulfur(override val count : Float) : Item(productionTime = 1F ,
    count = count,
    formula = listOf(
        Water(count*30/2),
        PetroliumGas(count*30/2),
    )
)
{
    override val automatSpeed: Float = 1F
}

data class Water(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
    )
)

data class SummaryBootle(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
        GreenBootle(count),
        RedBootles(count),
        BlueBootle(count),
        PurpleBootle(count),
        YellowBootle(count),
    )
)

data class YellowBootle(override val count : Float) : Item(productionTime = 21F/3F ,
    count = count,
    formula = listOf(
        Proccessor(count*2/3),
        RobotFrame(count*1/3),
        Structure(count*3/3),
    )
)

data class Proccessor(override val count : Float) : Item(productionTime = 10F ,
    count = count,
    formula = listOf(
        GreenElectricPlate(count*20),
        RedElecticPlate(count*2),
        SulfureAtid(count*5),
    )
)

data class SulfureAtid(override val count : Float) : Item(productionTime = 1F/50F ,
    count = count,
    formula = listOf(
        Iron(count*1/50),
        Sulfur(count*5/50),
        Water(count*100/50),
    )
)
{
    override val automatSpeed: Float = 1F
}

data class RobotFrame(override val count : Float) : Item(productionTime = 20F ,
    count = count,
    formula = listOf(
        SteelPlate(count*1),
        Battery(count*2),
        GreenElectricPlate(count*3),
        ElectricEngine(count*1),
    )
)

data class ElectricEngine(override val count : Float) : Item(productionTime = 10F ,
    count = count,
    formula = listOf(
        Engine(count*1),
        GreenElectricPlate(count*2),
        Lubricant(count*15)
    )
)

data class Lubricant(override val count : Float) : Item(productionTime = 1F/10F ,
    count = count,
    formula = listOf(
        HeavyOil(count*1),
    )
)
{
    override val automatSpeed: Float = 1F
}

data class HeavyOil(override val count : Float) : Item(productionTime = 0F ,
    count = count,
    formula = listOf(
    )

)

data class Battery(override val count : Float) : Item(productionTime = 4F ,
    count = count,
    formula = listOf(
        Iron(count*1),
        Cooper(count*1),
        SulfureAtid(count*20),
    )
)
{
    override val automatSpeed: Float = 1F
}

data class Structure(override val count : Float) : Item(productionTime = 20F ,
    count = count,
    formula = listOf(
        Cooper(count*20),
        SteelPlate(count*2),
        Plastic(count*5),
    )
)