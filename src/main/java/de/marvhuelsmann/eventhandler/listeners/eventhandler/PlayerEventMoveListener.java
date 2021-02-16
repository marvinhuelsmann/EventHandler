package de.marvhuelsmann.eventhandler.listeners.eventhandler;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.anotations.Anotations;
import de.marvhuelsmann.eventhandler.api.events.JoinEvent;
import de.marvhuelsmann.eventhandler.api.events.MoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class PlayerEventMoveListener implements Listener {

    @EventHandler
    public void on(MoveEvent e) {

        EventManager.getInstance().getAnotationFinder().runAnotation(Anotations.ONMOVE, e.getEventPlayer());

    }
}
