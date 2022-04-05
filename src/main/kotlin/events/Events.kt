package events

import entities.EnemyConstructor
import entities.Player
import objects.Enemy
import kotlin.random.Random

class Events {
    private val enemies = EnemyConstructor()

    fun spawnEnemy(): Enemy {
        var enemy = enemies.skeleton
        when (Random.nextInt(0, 4)) {
            0 -> enemy = enemies.skeleton
            1 -> enemy = enemies.spider
            2 -> enemy = enemies.troll
            3 -> enemy = enemies.goblin
        }
        return enemy
    }

    fun startFight(player: Player) {
        val enemy = spawnEnemy()
        var flee = false

        println("Bojuješ proti ${enemy.type}")
        println("Jeho staty jsou dmg - ${enemy.dmg} def - ${enemy.def} hp - ${enemy.hp} agi -  ${enemy.agi}")
        println("Co chceš dělat ? Dostupné příkazy - boj(b), utek(u)")
        while (true) {
            when (readln()) {
                "u" -> {
                    val chanceOnEscape = Random.nextInt(0,9)
                    if(chanceOnEscape > 8) {
                        println("Možná si tímto útěkem nezachováš čest, ale alespoň život ano")
                        flee = true
                        break
                    }
                    else{
                        println("Zakopl si a nepodařilo se ti utéct")
                    }
                }

                "b" -> {
                    break
                }
                else -> println("Lmao jsi retard a neumíš psát. Máš další pokus")
            }
        }

        if(!flee){
            while (true) {
                player.attack(enemy)
                enemy.attack(player)
            }
        }
    }
}