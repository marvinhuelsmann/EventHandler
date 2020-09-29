package de.marvhuelsmann.eventhandler.eventplayer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.net.InetAddress;

public class EventPlayer {

    protected final Player eventPlayer;

    public EventPlayer(Player player) {
        this.eventPlayer = player;
    }

    public Player bukkit() {
        return Bukkit.getPlayer(eventPlayer.getUniqueId());
    }

    public InetAddress getIp() {
        return eventPlayer.getAddress().getAddress();
    }

}
