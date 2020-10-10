package de.marvhuelsmann.eventhandler.api.events;

import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoveEvent extends Event {

    public static HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final EventPlayer eventPlayer;

    public MoveEvent(EventPlayer eventPlayer) {
        this.eventPlayer = eventPlayer;

    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public String getCurrentTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public Location getCurentPlayerLocation() {
        return eventPlayer.bukkit().getLocation();
    }
}
