import kotlin.math.roundToInt
import kotlin.properties.Delegates

internal class Player(attack: Int, defense: Int, health: Int, damage: IntRange)
    : Creature(attack = attack, defense = defense, health = health, damage = damage) {

    private var healCounter: Int = 0
    private val maxHealth = health

    override var health: Int by Delegates.observable(health) {
        _, _, value ->
            if ((value == 0 || value < 0) && isAlive) {
                heal()
            }
    }


    private fun heal() {
        healCounter++
        if (healCounter < 5) {
            println(Resources.PLAYER_HEALING + healCounter)
            health += (maxHealth * 0.3).roundToInt()
        } else {
            isAlive = false
            info()
        }
    }

    override fun info() {
        println(Resources.PLAYER_DEAD)
    }

}