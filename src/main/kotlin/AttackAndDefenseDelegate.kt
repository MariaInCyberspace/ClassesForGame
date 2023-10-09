
import java.lang.IllegalArgumentException
import kotlin.reflect.KProperty

internal class AttackAndDefenseDelegate() {
    constructor(initialValue: Int = 1) : this() {
        setValue(null, null, initialValue)
    }

    private val minValue = 1
    private val maxValue = 30

    private var fieldData: Int = minValue

    operator fun getValue(thisRef: Any?, property: KProperty<*>?): Int {
        return fieldData
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>?, value: Int) {
        fieldData = try {
            if (value in minValue..maxValue) {
                value
            } else {
                throw IllegalArgumentException("$value " + Resources.ATTACK_DEFENSE_EXCEPTION_MESSAGE)
            }
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
            if (value > maxValue) 30
            else 1
        }
    }

}