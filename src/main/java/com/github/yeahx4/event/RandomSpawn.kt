package com.github.yeahx4.event

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class RandomSpawn : Listener {
  @EventHandler
  fun onPlayerJoin(event: PlayerJoinEvent) {
    event.joinMessage = "${ChatColor.GREEN}+${event.player.name}"
  }
}
