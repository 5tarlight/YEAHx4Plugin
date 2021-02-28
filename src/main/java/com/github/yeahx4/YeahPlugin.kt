package com.github.yeahx4

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class YeahPlugin : JavaPlugin() {
  override fun onEnable() {
    Bukkit.getConsoleSender().sendMessage("YEAHx4 Enabled")
  }
}
