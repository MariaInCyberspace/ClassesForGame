import java.lang.IllegalArgumentException
import kotlin.properties.Delegates


internal abstract class Creature (attack: Int, defense: Int, health: Int, damage: IntRange) {
    private var attack: Int by AttackAndDefenseDelegate(attack)
    private var defense: Int by AttackAndDefenseDelegate(defense)
    protected var isAlive: Boolean = true
    protected val initialHealth: Int

    init {
        initialHealth = if (health < 0) {
            try {
                throw IllegalArgumentException("$health: " + Resources.HEALTH_VAL_EXCEPTION)
            } catch (ex: IllegalArgumentException) {
                ex.printStackTrace()
            }
            1
        } else {
            health
        }
    }


    protected open var health: Int by Delegates.observable(initialHealth) {
            _, _, new ->
        if (new == 0 || new < 0) {
            isAlive = false
            info()
            return@observable
        }
    }

    private val damage: IntRange by lazy {
        if (damage.first < 1 || damage.last < 1 || (damage.first > damage.last)) {
            try {
                throw IllegalArgumentException("(${damage.first}, ${damage.last}): " + Resources.ILLEGAL_RANGE)
            } catch (ex: IllegalArgumentException) {
                ex.printStackTrace()
            }
            1..6
        } else {
            damage
        }
    }

    internal fun hit(defender: Creature) {
        val success = HitStatus.determineSuccess(attack, defender.defense)
        if (success) {
            defender.health = defender.health - damage.random()
        }
    }

    internal fun checkIfAlive() : Boolean {
        return isAlive
    }

    internal fun checkHealth() : Int {
        return health
    }

    protected open fun info() {
        println(Resources.CREATURE_DEAD)
    }

}





