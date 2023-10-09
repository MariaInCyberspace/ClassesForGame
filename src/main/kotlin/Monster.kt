internal class Monster(attack: Int, defense: Int, health: Int, damage: IntRange)
    : Creature(attack = attack, defense = defense, health = health, damage = damage) {

    override fun info() {
        println(Resources.MONSTER_DEAD)
    }
}