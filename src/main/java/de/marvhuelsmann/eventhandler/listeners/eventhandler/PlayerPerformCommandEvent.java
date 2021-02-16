package de.marvhuelsmann.eventhandler.listeners.eventhandler;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.anotations.Anotations;
import de.marvhuelsmann.eventhandler.api.events.PerfomCommandEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerPerformCommandEvent implements Listener {

    @EventHandler
    public void on(PerfomCommandEvent e) {
        e.getEventPlayer().bukkit().sendMessage(e.getCommand());

        EventManager.getInstance().getAnotationFinder().runAnotation(Anotations.ONCOMMAND, e.getEventPlayer());
    }
}
