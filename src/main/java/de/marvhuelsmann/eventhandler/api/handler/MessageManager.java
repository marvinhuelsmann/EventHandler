package de.marvhuelsmann.eventhandler.api.handler;

import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import org.bukkit.entity.Player;

public class MessageManager implements Message {

    @Override
    public void send(Player p, String message) {
        p.sendMessage(message);
    }

    @Override
    public void send(EventPlayer eventPlayer, String message) {
        eventPlayer.bukkit().sendMessage(message);
    }
}
