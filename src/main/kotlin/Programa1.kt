fun main(){
    //puntos iniciales
    var a:Punto = Punto("a", 3, 2)
    println(a.toString())
    var b:Punto = Punto("b", 1, 3)
    println(b.toString())

    //punto final
    var ab:Punto = Punto.componenteDeVector(a, b)
    println(ab.toString())
}