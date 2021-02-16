package de.marvhuelsmann.eventhandler;

import de.marvhuelsmann.eventhandler.anotations.AnotationFinder;
import de.marvhuelsmann.eventhandler.api.handler.Message;
import de.marvhuelsmann.eventhandler.api.handler.MessageManager;
import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerCommandPreprocessListener;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerJoinListener;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerMoveListener;
import de.marvhuelsmann.eventhandler.listeners.bukkit.PlayerQuitListener;
import de.marvhuelsmann.eventhandler.listeners.eventhandler.PlayerEventJoinListener;
import de.marvhuelsmann.eventhandler.listeners.eventhandler.PlayerPerformCommandEvent;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EventManager extends JavaPlugin {

    @Getter
    public static EventManager instance;
    @Getter
    private AnotationFinder anotationFinder;
    @Getter
    private Message messageManager;

    protected void setInstance(final EventManager instance) {
        if (null != instance) {
            EventManager.instance = instance;
        } else {
            System.err.println("instance already set!");
        }
    }

    @Override
    public void onEnable() {

        System.out.println("§aLoaded EventHandler");
        setInstance(this);

        new AnotationFinder().detectAnotation("de.marvhuelsmann.eventhandler.anotations.events");

        System.out.println("§2Loaded Bukkit Events....");
        loadBukkitEvents();
        System.out.println("§2Loaded Specific Events....");
        loadSpecificEvents();
        System.out.println("§2Loaded Commands");
        loadCommands();
        System.out.println("Load other Stuff");
        loadManager();

    }

    private void loadManager() {
        this.anotationFinder = new AnotationFinder();
        this.messageManager = new MessageManager();
    }

    private void loadBukkitEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocessListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), EventManager.getInstance());

    }

    private void loadSpecificEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayerEventJoinListener(), EventManager.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerPerformCommandEvent(), EventManager.getInstance());

    }

    private void loadCommands() {
    }

    public EventPlayer getEventHandler(Player player) {
        return new EventPlayer(player);
    }


    @Override
    public void onDisable() {
        System.out.println("§4Unloaded EventHandler");
    }
}
