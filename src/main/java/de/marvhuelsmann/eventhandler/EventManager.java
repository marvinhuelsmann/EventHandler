package de.marvhuelsmann.eventhandler;

import de.marvhuelsmann.eventhandler.api.handler.MessageManager;
import de.marvhuelsmann.eventhandler.api.interfaces.Message;
import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerCommandPreprocessListener;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerJoinListener;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerQuitListener;
import de.marvhuelsmann.eventhandler.listeners.eventhandler.PlayerEventJoinListener;
import de.marvhuelsmann.eventhandler.listeners.eventhandler.PlayerPerfonCommandEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager extends JavaPlugin {

    @Getter
    private static EventManager instance;
    @Getter
    public Message messageManager;

    protected void setInstance(final EventManager instance) {
        if (instance == null) {
            System.err.println("EventHandler instance cannot be set twice!");
        } else {
            EventManager.instance = instance;
        }
    }

    @Override
    public void onEnable() {

        System.out.println("§aLoaded EventHandler");
        setInstance(this);
        System.out.println("§2Loaded Bukkit Events....");
        loadBukkitEvents();
        System.out.println("§2Loaded Specific Events....");
        loadSpecificEvents();
        System.out.println("§2Loaded Commands");
        loadCommands();
        System.out.println("Load other Stuff");

    }

    private void loadBukkitEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), EventManager.getInstance());

    }

    private void loadSpecificEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerEventJoinListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerPerfonCommandEvent(), EventManager.getInstance());

    }

    private void loadCommands() {}

    public EventPlayer getEventHandler(Player player) {
        return new EventPlayer(player);
    }


    @Override
    public void onDisable() {
        System.out.println("§4Unloaded EventHandler");
    }
}
