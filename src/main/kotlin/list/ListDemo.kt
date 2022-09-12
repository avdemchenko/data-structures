package list

fun main() {
    showArrayList()
}

fun showArrayList() {
    val list = ArrayListCustom<String>()

    list.add("First")
    list.add("Second")
    list.add("Third")
    list.add("Fourth")
    list.add("Fifth")

    println(list.visualise())

    println("Size: " + list.size())
    println("First element: " + list.first())
    println("Last element: " + list.last())
    println("Removed: " + list.remove(1))
    println("Contains: " + list.contains("Third"))
}
