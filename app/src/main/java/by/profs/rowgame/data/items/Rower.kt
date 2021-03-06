package by.profs.rowgame.data.items

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.profs.rowgame.utils.TABLE_ROWERS

@Entity(tableName = TABLE_ROWERS)
data class Rower(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "name_surname") val name: String,
    @ColumnInfo(name = "gender") val gender: Int,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "weight") val weight: Int,
    @ColumnInfo(name = "power") var power: Int,
    @ColumnInfo(name = "technics") var technics: Int,
    @ColumnInfo(name = "endurance") var endurance: Int,
    @ColumnInfo(name = "thumb") val thumb: String? = null,
    @ColumnInfo(name = "photo") val photo: String? = null,
    @ColumnInfo(name = "endpointAbout") val endpointAbout: String? = null,
    @ColumnInfo(name = "cost") val cost: Int = 0
) {
    companion object {
        const val MALE = 1
        const val FEMALE = 2
    }

    fun upEndurance(level: Int = 1) { endurance += level }

    fun upPower(level: Int = 1) { power += level }

    fun upTechnics(level: Int = 1) { technics += level }
}