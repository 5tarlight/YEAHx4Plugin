package com.github.yeahx4.cmd

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class YLocCommand : CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
    if (sender is Player) {
      sender.sendMessage("Y : ${sender.location.y}")
      return true
    } else {
      sender.sendMessage("On players can use this comand")
      return false
    }
  }
}
