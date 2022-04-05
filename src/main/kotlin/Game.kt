import entities.Player
import objects.Map

class Game {
    private val player = Player()
    private val map = Map()


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

        }
    }
}