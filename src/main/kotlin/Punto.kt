import kotlin.math.sqrt

class Punto(id: String) {

    val idPunto: String = id
    var posX: Int = 0
    var posY: Int = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.posX = x
        this.posY = y
    }

    fun obtenerCoordenadas() = Pair(this.posX, this.posY)
    override fun toString() = "punto <$idPunto> -> [<$posX>,<$posY>]"
}

fun componenteDeVector(p1: Punto, p2: Punto): Punto =
    Punto(
        p1.idPunto + "," + p2.idPunto,
        p2.obtenerCoordenadas().first - p1.obtenerCoordenadas().first,
        p2.obtenerCoordenadas().second - p1.obtenerCoordenadas().second
    )

//Opicional
fun distancia(p1: Punto, p2: Punto): Double =
    sqrt(
        Math.pow(
            (p2.obtenerCoordenadas().first - p1.obtenerCoordenadas().first).toDouble(),
            2.0
        ) + Math.pow((p2.obtenerCoordenadas().first - p1.obtenerCoordenadas().first).toDouble(), 2.0)
    )

fun localizacionGeograficaNS(lista: List<Punto>): Map<String, List<Punto>> {
    val ite = lista.listIterator()
    var loc: MutableMap<String, List<Punto>> = mutableMapOf()
    var norte: MutableList<Punto> = mutableListOf()
    var sur: MutableList<Punto> = mutableListOf()
    for (i in ite) {
        if (i.posY >= 0) {
            norte.add(i)
        } else {
            sur.add(i)
        }
    }
    loc.put("Norte", norte)
    loc.put("Sur", sur)
    return loc
}

fun programa1(){
    //puntos iniciales
    var a:Punto = Punto("a", 3, 2)
    println(a.toString())
    var b:Punto = Punto("b", 1, 3)
    println(b.toString())

    //punto final
    var ab:Punto = componenteDeVector(a, b)
    println(ab.toString())
}

fun programa2(){
    //Lista de puntos
    var lista: List<Punto> = listOf(
        Punto("p1", -1, 0),
        Punto("p2", 3, -1),
        Punto("p3", -4, 4),
        Punto("p4", -3, 2),
        Punto("p5", 6, -4),
        Punto("p6", -5, 6),
        Punto("p7", 10, -8),
        Punto("p8", 1, 5),
        Punto("p9", 6, -7)
    )
    //Uso la funcion localizacionGeograficaNS para sacar los puntos del norte y del sur
    println("Norte: ${localizacionGeograficaNS(lista)["Norte"]}")
    println("Sur: ${localizacionGeograficaNS(lista)["Sur"]}")
}

fun main() {
    //programa1()
    //programa2()
}