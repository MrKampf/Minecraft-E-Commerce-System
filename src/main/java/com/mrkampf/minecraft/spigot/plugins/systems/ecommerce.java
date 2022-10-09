package com.mrkampf.minecraft.spigot.plugins.systems;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class ecommerce extends JavaPlugin {

    private final PluginDescriptionFile pluginInfo = this.getDescription();

    @Override
    public void onEnable() {
        System.out.println("E-Commerce system is loading...");
        System.out.println("Version " + pluginInfo.getVersion() + " by " + pluginInfo.getAuthors());

        this.registerCommands();
        this.registerEvents();

        System.out.println("E-Commerce system is loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        // Register commands
    }

    private void registerEvents() {
        // Register events
    }
}
