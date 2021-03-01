package com.github.yeahx4.cmd

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class Introduction : CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
    sender.sendMessage("=============================")
    sender.sendMessage("")
    sender.sendMessage("YEAHx4 Server")
    sender.sendMessage("경쟁형 PVP, 야생")
    sender.sendMessage("")
    sender.sendMessage("스폰 파괴를 제외한, 함정, 일자굴, 약탈 등 모든것이 허용됩니다!")
    sender.sendMessage("다만 상대가 기분나쁠 수 있는 비하나 농락 등은 하지 말것")
    sender.sendMessage("")
    sender.sendMessage("")
    sender.sendMessage("이 서버에서는 자신의 좌표를 볼 수 없습니다만, 편의성을 위해")
    sender.sendMessage("/y 또는 /yeahx4:y 커맨드를 통해 자신의 y좌표를 알 수 있습니다.")
    sender.sendMessage("")
    sender.sendMessage("=============================")

    return true
  }
}
