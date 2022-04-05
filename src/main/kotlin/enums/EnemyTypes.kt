package enums

enum class EnemyTypes(name: String, var hp: Int, var agi: Int, var def: Int, var dmg: Int, var value: Int) {
    SKELETON("kostlivci",15,6,0,7,3),
    SPIDER("pavoukovi",10,7,2,6,5),
    TROLL("trollovi",51,3,3,6,7),
    GOBLIN("goblinovi",20,5,4,11,10)
}