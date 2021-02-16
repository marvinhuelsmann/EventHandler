package de.marvhuelsmann.eventhandler.listeners.eventhandler;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.anotations.Anotations;
import de.marvhuelsmann.eventhandler.api.events.JoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerEventJoinListener implements Listener {

    @EventHandler
    public void on(JoinEvent e) {

        EventManager.getInstance().getAnotationFinder().runAnotation(Anotations.ONJOIN, e.getEventPlayer());

    }
}
