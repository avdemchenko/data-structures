package list

fun main() {
    showArrayList()
    showLinkedList()
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

fun showLinkedList() {
    val list = LinkedListCustom<String>()

    list.push("First")
    list.push("Second")
    list.push("Third")
    list.push("Fourth")
    list.push("Fifth")

    println(list)

    list.append("First")
    list.append("Second")
    list.append("Third")
    list.append("Fourth")
    list.append("Fifth")

    println(list)
}
