fun main() {

    val list = listOf("1", "2", "3", "4")
//    val list = listOf(1,2,3,4)
    val map = list.map { it.toInt() }


    val transform: (String) -> Int = { it.toInt() }
    val convertStringToInt = list.ourMap(transform)
    println(convertStringToInt)
    val convertStringToInt2 = list.ourMap { it.toInt() + 10 }
    println(convertStringToInt2)

    val listOfFloat = listOf<Float>(1.0f)
    val ourMap = listOfFloat.ourMap { it.toString() + "abc"}
    println(ourMap)

    val set = setOf<String>("1", "2", "3", "4")
    set.map {  }

//    set.ourMap
    val lib = Library()
    lib.ourMap {  }
}

inline fun <T, R> Iterable<T>.ourMap(transform: (T) -> R): List<R> {
    val size = if(this is Collection) this.size else 10
    val destination = ArrayList<R>(size)
    for (s in this) {
        destination.add(transform(s))
    }
    return destination
}


class Library : Iterable<Int>{
    override fun iterator(): Iterator<Int> {
        TODO("Not yet implemented")
    }

}


































