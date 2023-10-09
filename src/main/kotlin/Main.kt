fun main(args: Array<String>) {

    val player = Player(20, 23, 10, 1..5)
    val monster = Monster(24, 20, 15, 2..4)

    Fight.start(player, monster)

}