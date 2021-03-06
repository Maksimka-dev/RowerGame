package by.profs.rowgame.data

import android.content.SharedPreferences
import by.profs.rowgame.data.combos.CombinationSingleScull
import by.profs.rowgame.utils.BOAT
import by.profs.rowgame.utils.DAY
import by.profs.rowgame.utils.FAME
import by.profs.rowgame.utils.FIRST_OAR
import by.profs.rowgame.utils.FIRST_ROWER
import by.profs.rowgame.utils.MONEY
import by.profs.rowgame.utils.START_FAME
import by.profs.rowgame.utils.START_MONEY_BALANCE
import by.profs.rowgame.utils.UNDEFINED

class PreferenceEditor(private val preferences: SharedPreferences) {
    fun getBalance(): Int {
        var balance = preferences.getInt(MONEY, UNDEFINED)
        if (balance == UNDEFINED) {
            balance = START_MONEY_BALANCE
            setBalance(balance)
        }
        return balance
    }

    fun setBalance(money: Int) {
        preferences.edit().apply {
            putInt(MONEY, money)
            apply()
        }
    }

    fun getFame(): Int {
        var fame = preferences.getInt(FAME, UNDEFINED)
        if (fame == UNDEFINED) {
            fame = START_FAME
            setFame(fame)
        }
        return fame
    }

    fun setFame(fame: Int) {
        preferences.edit().apply {
            putInt(FAME, fame)
            apply()
        }
    }

    fun occupyBoat(id: Int) {
        preferences.edit().apply() {
            putInt(BOAT, id)
            apply()
        }
    }

    fun occupyRower(id: String, number: Int = 1) {
        preferences.edit().apply() {
            putString(when (number) { else -> FIRST_ROWER }, id)
            apply()
        }
    }

    fun occupyOar(id: Int, number: Int = 1) {
        preferences.edit().apply() {
            putInt(when (number) { else -> FIRST_OAR }, id)
            apply()
        }
    }

    fun getCombo() = CombinationSingleScull(
        null,
        preferences.getInt(BOAT, 0),
        preferences.getInt(FIRST_OAR, 0),
        preferences.getString(FIRST_ROWER, "")!!
    )

    fun getDay(): Int {
        var day = preferences.getInt(DAY, lastDay)
        if (day == lastDay) day = 1
        return day
    }

    fun nextDay() {
        preferences.edit().apply {
            putInt(DAY, getDay() + 1)
            apply()
        }
    }

    companion object {
        const val lastDay = 366
    }
}