fun main() {
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
    println("Norte: ${Punto.localizacionGeograficaNS(lista)["Norte"]}")
    println("Sur: ${Punto.localizacionGeograficaNS(lista)["Sur"]}")
}