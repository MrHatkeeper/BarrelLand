package entities

import events.Events
import objects.Enemy
import objects.Map
import kotlin.random.Random


class Player {
    var hpMax = 20
    var agiMax = 5
    var defMax = 5
    var dmg = 3
    var gold = 0
    var hp = hpMax
    var agi = agiMax
    var def = defMax


    var position = intArrayOf(0, 0)
    var chanceOnRanEncounter = 5


    var events = Events()
    fun move(map: Map) {
        println("\nTvá pozice je X ${position[0]} a pozice Y je ${position[1]} Dostupné příkazy - mapa(m), doleva(l), doprava(p), nahoru(n), dolu(d)")
        when (readln()) {
            "l" -> {
                position[0] += 1
                chanceOnRanEncounter += 1
            }
            "p" -> {
                position[0] += 1
                chanceOnRanEncounter -= 1
            }
            "n" -> {
                position[1] += 1
                chanceOnRanEncounter -= 1
            }
            "d" -> {
                position[1] -= 1
                chanceOnRanEncounter -= 1
            }
            "m" -> {
                println("Mighty barel je od tebe vzdálený: ${map.mightyCity.position[0] - position[0]} po ose X a ${map.mightyCity.position[1] - position[1]} po ose Y")
                println("Nevyčištěné dunegony jsou od tebe vzdálené: ")
                for (dungeon in map.dungeons) {
                    if (!dungeon.isClear) {
                        println("${dungeon.position[0] - position[0]} po ose X a ${dungeon.position[1] - position[1]} po ose Y")
                    }
                }
            }
        }
        if (chanceOnRanEncounter <= 2 && Random.nextBoolean()) events.spawnEnemy()
    }

    fun attack(enemy: Enemy): Enemy {
        println("Na jakou část těla utočíš ? - hlava(h), telo(t), nohy(n)")
        when (readln()) {
            "h" -> {
                if (!dodge(enemy)) {
                    enemy.hp -= dmg
                    enemy.def -= 1

                    println("Dáváš poškození za $dmg")
                    println("Oponent má ${enemy.hp} hp a snížil se mu def na  ${enemy.def}")
                } else {
                    println("Minul jsi")
                }
            }
            "t" -> {
                if (!dodge(enemy)) {
                    enemy.hp -= dmg

                    println("Dáváš poškození za $dmg")
                    println("Oponent má ${enemy.hp} hp")
                } else {
                    println("Minul jsi")
                }
            }
            "n" -> {
                if (!dodge(enemy)) {
                    enemy.hp -= dmg
                    enemy.agi -= 1

                    println("Dáváš poškození za $dmg")
                    println("Oponent má ${enemy.hp} hp a snížil se mu agi na  ${enemy.agi}")
                } else {
                    println("Minul jsi")
                }
            }
        }
        return enemy
    }

    private fun dodge(enemy: Enemy): Boolean {
        TODO()
    }

    fun death(): Boolean {
        return (hp <= 0)
    }

    fun escape(): Boolean {
        TODO()
    }
}