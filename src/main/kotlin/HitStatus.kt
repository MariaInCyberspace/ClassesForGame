internal object HitStatus {
    private fun calculateAttackModifier(attack: Int, defense: Int) : Int {
        return if (attack - defense < 0) {
            1
        } else {
            attack - defense + 1
        }
    }

    fun determineSuccess(attack: Int, defense: Int) : Boolean {
        val attackModifier = calculateAttackModifier(attack, defense)
        for (i in 1..attackModifier) {
            val success = (1..6).random() // throw dice
            if (success in 5..6) {
                println(Resources.SUCCESSFUL_ATTACK)
                return true
            } else {
                println(Resources.ATTACK_FAILED_MESSAGE)
            }
        }
        return false
    }

}