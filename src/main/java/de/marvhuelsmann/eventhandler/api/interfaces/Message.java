package de.marvhuelsmann.eventhandler.api.interfaces;

import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import org.bukkit.entity.Player;

public interface Message {

    void send(Player p, String message);

    void send(EventPlayer eventPlayer, String message);
}
