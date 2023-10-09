internal object Fight {
    private lateinit var player: Player
    private lateinit var monster: Monster

    private fun setFighters(p: Player, m: Monster) {
        player = p
        monster = m
    }

    fun start(p: Player, m: Monster) {
        setFighters(p, m)
        println(Resources.PLAYERS_ENTERED_FIGHT)
        println(Resources.PLAYER_HEALTH_INFO + "${player.checkHealth()}, " + Resources.MONSTER_HEALTH_INFO + "${monster.checkHealth()} \n")

        do {
            println(Resources.MONSTER_ATTACKS_MSG)
            monster.hit(player)
            println(Resources.PLAYER_HEALTH_INFO + "${player.checkHealth()}")
            Thread.sleep(1000)
            if (!player.checkIfAlive()) {
                break
            } else {
                println(Resources.PLAYER_ATTACKS_MSG)
                player.hit(monster)
                println(Resources.MONSTER_HEALTH_INFO + "${monster.checkHealth()} \n")
            }
            Thread.sleep(1000)

        } while (monster.checkIfAlive())
    }
}