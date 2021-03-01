package com.github.yeahx4.event

import com.github.yeahx4.YeahPlugin
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.plugin.Plugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class PlayerRespawn(plugin: Plugin) : Listener {
  val plugin = plugin

  @EventHandler
  fun onPlayerRespawn(event: PlayerRespawnEvent) {
    val task = Runnable {
      event.player.addPotionEffect(
        PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 225)
      )
    }

    Bukkit.getServer().scheduler.scheduleAsyncDelayedTask(plugin, task, 20)
  }
}
