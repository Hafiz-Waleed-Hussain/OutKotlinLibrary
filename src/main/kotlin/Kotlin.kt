import java.util.Collections

fun main() {

    /*****************
    Prerequisite:
    1. Class Hierarchy of JDK Collection APIs
    2. Extension Function in Kotlin
    3. Iterable Interface
     *****************/


    val list = mutableListOf("1", "2", "3", "4")
//    val list = listOf(1,2,3,4)
    println("Kotlin : " + list.map { it.toInt() })
    println("Our    : " + list.ourMap { it.toInt() })

    val mapTo = ArrayList<Int>()
    list.mapTo(mapTo) { it.toInt() }
    println("Kotlin : " + mapTo)

    val ourMapTo = ArrayList<Int>()
    list.ourMapTo(ourMapTo) { it.toInt() }
    println("Our    : " + ourMapTo)

    val data = listOf("a", "b", "c")
    data.ourMapTo(list) { it + " post" }
    println(list)

    val newData = data.ourMap { it + " post" }
    list.addAll(newData)
    println(list)

}

inline fun <T, R> Iterable<T>.ourMap(transform: (T) -> R): List<R> {
    val size = if (this is Collection) this.size else 10
    return ourMapTo(ArrayList<R>(size), transform)
}

inline fun <T, R, C : MutableCollection<in R>> Iterable<T>.ourMapTo(destination: C, transform: (T) -> R): C {
    for (item in this) {
        destination.add(transform(item))
    }
    return destination
}



































