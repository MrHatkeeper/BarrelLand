package objects

import objects.structures.City
import objects.structures.Dungeon

class Map {
    var mightyCity = City("Mighty City",1,0)
    var dungeons = arrayListOf(Dungeon(0,5),Dungeon(5,15),Dungeon(6,8),Dungeon(-8,12))
}