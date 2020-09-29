package de.marvhuelsmann.eventhandler.listeners.bukkit;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.api.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        Bukkit.getPluginManager().callEvent(new JoinEvent(EventManager.getInstance().getEventHandler(e.getPlayer())));
    }
}
