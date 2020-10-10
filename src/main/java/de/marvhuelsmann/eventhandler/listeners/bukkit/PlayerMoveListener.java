package de.marvhuelsmann.eventhandler.listeners.bukkit;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.api.events.MoveEvent;
import jdk.Exported;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Bukkit.getPluginManager().callEvent(new MoveEvent(EventManager.getInstance().getEventHandler(p)));
    }
}
