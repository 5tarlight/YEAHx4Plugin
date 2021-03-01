package com.github.yeahx4.event

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.io.*

class RandomSpawn : Listener {
  class SpanwPoint(x: Int, z: Int) : Serializable {
    val y = 100
    var x: Int = x
    var z: Int = z
  }

  val minX = -800
  val maxX = 1200
  val minZ = -700
  val maxZ = 1300

  private fun getRandomNumber(min: Int, max: Int): Int {
    return ((Math.random() * (max - min)) + min).toInt()
  }

  @EventHandler
  fun onPlayerJoin(event: PlayerJoinEvent) {
    event.joinMessage = "${ChatColor.GREEN}+${event.player.name}"

    val player = event.player
    val dir = "plugins/YEAHx4"
    val path = "${dir}/${player.uniqueId}.spawn"

    try {
      val d = File(dir)
      val f = File(path)

      if (!d.exists()) {
        d.mkdirs()
      }

      if (f.exists()) {
        // not fist join
        player.sendMessage("인증되었습니다.")
      } else {
        // first join
        var spawnX = 200
        var spawnZ = 300

        do {
          spawnX = getRandomNumber(minX, maxX)
        } while (!(spawnX <= 0 || spawnX >= 400))
        do {
          spawnZ = getRandomNumber(minZ, maxZ)
        } while (!(spawnZ <= 100 || spawnZ >= 500))

        val point = SpanwPoint(spawnX, spawnZ)
        val y = player.world.getHighestBlockYAt(spawnX, spawnZ) + 3

        player.addPotionEffect(
          PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 225)
        )

        player.teleport(
          Location(
            player.world,
            point.x.toDouble(),
            y.toDouble(),
            point.z.toDouble()
          )
        )

        val cmd = "spawnpoint ${player.name} ${point.x} $y ${point.z}"
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd)

        player.sendMessage("무작위 장소에 스폰되었습니다.")
        player.sendMessage("/intro 명령어로 도움말을 받을 수 있습니다.")

        val fos = FileOutputStream(path)
        val oos = ObjectOutputStream(fos)

        oos.writeObject(point)

        oos.close()
        fos.close()
      }
    } catch (e: Exception) {
      player.sendMessage("오류")
      Bukkit.getConsoleSender().sendMessage(e.stackTrace.toString())
    }
  }
}
