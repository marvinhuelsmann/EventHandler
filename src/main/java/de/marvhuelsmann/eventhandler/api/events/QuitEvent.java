package de.marvhuelsmann.eventhandler.api.events;

import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class QuitEvent extends Event {

    public static final HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final EventPlayer eventPlayer;

    public QuitEvent(EventPlayer eventPlayer) {
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

    public InetAddress getCurrentIp() {
        return eventPlayer.bukkit().getAddress().getAddress();
    }
}
