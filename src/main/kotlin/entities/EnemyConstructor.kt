package entities

import enums.EnemyTypes
import objects.Enemy

class EnemyConstructor{
    val skeleton = Enemy(
        type = EnemyTypes.SKELETON.name,
        hp = EnemyTypes.SKELETON.hp,
        agi = EnemyTypes.SKELETON.agi,
        def = EnemyTypes.SKELETON.def,
        dmg = EnemyTypes.SKELETON.dmg,
        value = EnemyTypes.SKELETON.value
    )
    val spider = Enemy(
        type = EnemyTypes.SPIDER.name,
        hp = EnemyTypes.SPIDER.hp,
        agi = EnemyTypes.SPIDER.agi,
        def = EnemyTypes.SPIDER.def,
        dmg = EnemyTypes.SPIDER.dmg,
        value = EnemyTypes.SPIDER.value
    )
    val troll = Enemy(
        type = EnemyTypes.TROLL.name,
        hp = EnemyTypes.TROLL.hp,
        agi = EnemyTypes.TROLL.agi,
        def = EnemyTypes.TROLL.def,
        dmg = EnemyTypes.TROLL.dmg,
        value = EnemyTypes.TROLL.value
    )
    val goblin = Enemy(
        type = EnemyTypes.GOBLIN.name,
        hp = EnemyTypes.GOBLIN.hp,
        agi = EnemyTypes.GOBLIN.agi,
        def = EnemyTypes.GOBLIN.def,
        dmg = EnemyTypes.GOBLIN.dmg,
        value = EnemyTypes.GOBLIN.value
    )
}
