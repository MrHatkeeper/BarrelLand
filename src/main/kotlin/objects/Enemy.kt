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
            0 -> {
                if (!dodge(player)) {
                    player.hp -= dmg
                    player.def -= 1

                    println("Oponent ti útočí na hlavu a dostáváš poškození poškození za $dmg")
                    println("Máš ${player.hp} hp a byla ti snížena def na ${player.def}")
                } else {
                    println("Oponent minul")
                }
            }
            1 -> {
                if (!dodge(player)) {
                    player.hp -= dmg

                    println("Oponent ti útočí na tělo a dostáváš poškození poškození za $dmg")
                    println("Máš ${player.hp} hp")
                } else {
                    println("Oponent minul")
                }
            }
            2 -> {
                if (!dodge(player)) {
                    player.hp -= dmg
                    player.agi -= 1

                    println("Oponent ti útočí na nohy a dostáváš poškození poškození za $dmg")
                    println("Máš ${player.hp} hp a snižuje ti agi na ${player.agi}")
                } else {
                    println("Oponent minul")
                }
            }
        }
        return player
    }

    private fun dodge(player: Player): Boolean {
        val dodgeChance = player.agi - agi
        if(dodgeChance > 0){
            if(Random.nextInt(3,10) < dodgeChance){
                return true
            }
        }
        return false
    }
}
