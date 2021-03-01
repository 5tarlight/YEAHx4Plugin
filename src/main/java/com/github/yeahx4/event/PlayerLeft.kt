package com.github.yeahx4.event

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerLeft : Listener {
  @EventHandler
  fun onPlayerLeft(event: PlayerQuitEvent) {
    event.quitMessage = "${ChatColor.RED}-${event.player.name}"
  }
}
