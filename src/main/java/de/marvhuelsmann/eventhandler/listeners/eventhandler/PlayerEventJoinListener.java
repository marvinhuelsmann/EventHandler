package de.marvhuelsmann.eventhandler.listeners.eventhandler;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.api.events.JoinEvent;
import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerEventJoinListener implements Listener {

    @EventHandler
    public void on(JoinEvent e) {
        EventPlayer eventPlayer = e.getEventPlayer();
        eventPlayer.bukkit().sendMessage(e.getCurrentTime() + e.getCurrentIp());


    }
}
