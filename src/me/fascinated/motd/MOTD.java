package me.fascinated.motd;

import me.fascinated.motd.commands.MOTDCommand;
import me.fascinated.motd.events.PingServerList;
import me.fascinated.motd.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getConsoleSender;

/**
 * Project: MOTD Manager
 * Date: Sat 25, May at 04:16
 * Created By: ImFascinated
 */
public class MOTD extends JavaPlugin {

    public static Config config;
    public static MOTD instance;

    public void onEnable () {
        instance = this;
        config = new Config(this, "config.yml", null);
        config.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PingServerList(), this);
        getCommand("motd").setExecutor(new MOTDCommand());
        getConsoleSender().sendMessage("§8§m-----------------------------------------");
        getConsoleSender().sendMessage("§aThis plugin was created by _Fascinated");
        getConsoleSender().sendMessage("");
        getConsoleSender().sendMessage("§cPlugin: §f" + getDescription().getName());
        getConsoleSender().sendMessage("§cVersion: §f" + getDescription().getVersion());
        getConsoleSender().sendMessage("");
        getConsoleSender().sendMessage("§aDiscord: §fImFascinated#4735");
        getConsoleSender().sendMessage("§aGitHub: §fgithub.com/RealFascinated");
        getConsoleSender().sendMessage("§aTwitter: §ftwitter.com/RealFascinated");
        getConsoleSender().sendMessage("§8§m-----------------------------------------");
    }
}
