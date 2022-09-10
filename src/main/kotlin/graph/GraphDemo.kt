import graph.AdjacencyList
import graph.AdjacencyMatrix
import graph.core.EdgeType.UNDIRECTED

fun main() {
    showAdjacencyList()
    showAdjacencyMatrix()
}

fun showAdjacencyList() {
    val graph = AdjacencyList<String>()

    val kharkiv = graph.createVertex("Kharkiv")
    val kyiv = graph.createVertex("Kyiv")
    val lviv = graph.createVertex("Lviv")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val dallas = graph.createVertex("Dallas")
    val seattle = graph.createVertex("Seattle")

    graph.add(UNDIRECTED, kharkiv, lviv, 500.0)
    graph.add(UNDIRECTED, kharkiv, kyiv, 300.0)
    graph.add(UNDIRECTED, lviv, kyiv, 100.0)
    graph.add(UNDIRECTED, kyiv, washingtonDC, 1000.0)
    graph.add(UNDIRECTED, lviv, sanFrancisco, 1500.0)
    graph.add(UNDIRECTED, dallas, washingtonDC, 400.0)
    graph.add(UNDIRECTED, sanFrancisco, washingtonDC, 350.0)
    graph.add(UNDIRECTED, washingtonDC, seattle, 390.0)
    graph.add(UNDIRECTED, sanFrancisco, seattle, 320.0)
    graph.add(UNDIRECTED, dallas, sanFrancisco, 305.0)

    println("\n========= Graph coordinates =======================\n")
    println(graph.visualise())
    println("\n========= Weight between Kharkiv and Kyiv =========\n")
    println(graph.weight(kharkiv, kyiv))
}

fun showAdjacencyMatrix() {
    val graph = AdjacencyMatrix<String>()

    val kharkiv = graph.createVertex("Kharkiv")
    val kyiv = graph.createVertex("Kyiv")
    val lviv = graph.createVertex("Lviv")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val dallas = graph.createVertex("Dallas")
    val seattle = graph.createVertex("Seattle")

    graph.add(UNDIRECTED, kharkiv, lviv, 500.0)
    graph.add(UNDIRECTED, kharkiv, kyiv, 300.0)
    graph.add(UNDIRECTED, lviv, kyiv, 100.0)
    graph.add(UNDIRECTED, kyiv, washingtonDC, 1000.0)
    graph.add(UNDIRECTED, lviv, sanFrancisco, 1500.0)
    graph.add(UNDIRECTED, dallas, washingtonDC, 400.0)
    graph.add(UNDIRECTED, sanFrancisco, washingtonDC, 350.0)
    graph.add(UNDIRECTED, washingtonDC, seattle, 390.0)
    graph.add(UNDIRECTED, sanFrancisco, seattle, 320.0)
    graph.add(UNDIRECTED, dallas, sanFrancisco, 305.0)

    println("\n========= Graph coordinates =======================\n")
    println(graph.visualise())
    println("\n========= Weight between Kharkiv and Kyiv =========\n")
    println(graph.weight(kharkiv, kyiv))
}
