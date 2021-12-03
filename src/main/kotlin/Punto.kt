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

    companion object{
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
    }
}