package com.github.yeahx4

import com.github.yeahx4.cmd.Introduction
import com.github.yeahx4.cmd.YLocCommand
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class YeahPlugin : JavaPlugin() {
  override fun onEnable() {
    Bukkit.getConsoleSender().sendMessage("YEAHx4 Enabled")

    getCommand("y")!!.setExecutor(YLocCommand())
    getCommand("intro")!!.setExecutor(Introduction())
  }
}
