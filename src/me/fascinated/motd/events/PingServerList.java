package me.fascinated.motd.events;

import me.fascinated.motd.MOTD;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Project: MOTD Manager
 * Date: Sat 25, May at 04:17
 * Created By: ImFascinated
 */
public class PingServerList implements Listener {

    FileConfiguration config = MOTD.config.getConfiguration();

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        String line1 = ChatColor.translateAlternateColorCodes('&', config.getString("MOTD.LINE1"));
        String line2 = ChatColor.translateAlternateColorCodes('&', config.getString("MOTD.LINE2"));
        event.setMotd(line1 + "\n" + line2);
    }
}
