package de.marvhuelsmann.eventhandler.listeners.bukkit;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.api.events.PerfomCommandEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerCommandPreprocessListener implements Listener {

    @EventHandler
    public void on(org.bukkit.event.player.PlayerCommandPreprocessEvent e) {
        if (e.getMessage().startsWith("/")) {
            String command = e.getMessage().replaceFirst("/", "");
            Bukkit.getPluginManager().callEvent(new PerfomCommandEvent(EventManager.getInstance().getEventHandler(e.getPlayer()), command));
        }
    }
}
