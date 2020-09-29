package de.marvhuelsmann.eventhandler.listeners.bukkit;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.api.events.QuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void on(PlayerQuitEvent e) {
        Bukkit.getPluginManager().callEvent(new QuitEvent(EventManager.getInstance().getEventHandler(e.getPlayer())));
    }


}
