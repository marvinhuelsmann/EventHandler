package de.marvhuelsmann.eventhandler.api.events;

import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PerfomCommandEvent extends Event {

    public static HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final EventPlayer eventPlayer;
    private final String command;

    public PerfomCommandEvent(EventPlayer eventPlayer, String command) {
        this.eventPlayer = eventPlayer;
        this.command = command;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public String getCommand() {
        return command;
    }


}
