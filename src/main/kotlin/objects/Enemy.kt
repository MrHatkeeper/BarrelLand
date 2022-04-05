package objects

import entities.Player
import interfaces.IEnemy
import kotlin.random.Random

data class Enemy(
    override var hp: Int = 0,
    override var agi: Int = 0,
    override var dmg: Int = 0,
    override var def: Int = 0,
    override val value: Int = 0,
    override var type: String = ""
) : IEnemy {



    fun dropGold(): Int {
        return Random.nextInt(0, value) + 1
    }

    fun attack(player: Player): Player {
        when (Random.nextInt(0, 3)) {
            1 -> {

            }
            2 -> {

            }
            else -> {

            }
        }
        return player
    }
}
