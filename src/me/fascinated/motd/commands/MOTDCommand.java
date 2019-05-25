package me.fascinated.motd.commands;

import me.fascinated.motd.MOTD;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Project: MOTD Manager
 * Date: Sat 25, May at 12:15
 * Created By: ImFascinated
 */
public class MOTDCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        CommandSender sender = s;
       if (sender.hasPermission("motd.command.admin")) {
           if (args.length < 1) {
               help(sender);
           } else {
               if (args[0].equalsIgnoreCase("reload")) {
                   sender.sendMessage("§e§lNotice §8▪ §fThe configuration is reloading...");
                   try {
                       sender.sendMessage("§a§lSuccess §8▪ §fThe configuration has reloaded!");
                       MOTD.config.reloadConfig();
                       MOTD.config.saveConfig();
                       MOTD.config.reloadConfig();
                   } catch (Exception ex) {
                       sender.sendMessage("§c§lError §8▪ §fThe configuration has failed to reload!");
                       ex.printStackTrace();
                   }
               }
           }
       } else {
           sender.sendMessage(ChatColor.translateAlternateColorCodes('&', MOTD.config.getConfiguration().getString("NO-PERMISSION")));
       }
        return true;
    }

    public void help(CommandSender sender) {
        sender.sendMessage("§8§m---------------------------------------");
        sender.sendMessage("§a§lMOTD §8┃ §fv" + me.fascinated.motd.MOTD.instance.getDescription().getVersion());
        sender.sendMessage("");
        sender.sendMessage("§8* §a/motd reload §8- §fReloads the config!");
        sender.sendMessage("§8§m---------------------------------------");
    }
}
