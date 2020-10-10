package de.marvhuelsmann.eventhandler.listeners.eventhandler;

import de.marvhuelsmann.eventhandler.api.events.PerfomCommandEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerPerfonCommandEvent implements Listener {

    @EventHandler
    public void on(PerfomCommandEvent e) {
        e.getEventPlayer().bukkit().sendMessage(e.getCommand());
    }
}
