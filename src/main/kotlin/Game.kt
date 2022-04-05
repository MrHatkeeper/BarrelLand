import entities.Player
import events.Events
import objects.Map
import kotlin.random.Random

class Game {
    private val player = Player()
    private val map = Map()
    private val events = Events()

    fun gameStart() {
        while (true) {
            player.move(map)
            if (player.position.contentEquals(map.mightyCity.position)) map.mightyCity.enterCity()
            for (dungeon in map.dungeons) {
                if (player.position.contentEquals(dungeon.position))
                    if (!dungeon.isClear) {
                        println("Tento dungeon už si dobyl")
                    } else {
                        dungeon.enterDungeon()
                    }
            }
            if(Random.nextInt(0,2) == 0) player.chanceOnRanEncounter--
            if(player.chanceOnRanEncounter <= 0){
                events.startFight(player)
                if (player.death()){
                    println("Umíráš po nezdařeném boji v kaluži krve")
                    print("Konec hry")
                    break
                }
                player.chanceOnRanEncounter = 5
            }
        }
    }
}