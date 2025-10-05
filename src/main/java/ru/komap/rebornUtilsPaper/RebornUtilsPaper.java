package ru.komap.rebornUtilsPaper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import ru.komap.rebornUtilsPaper.utils.*;
import ru.komap.rebornUtilsPaper.discord.DiscordBot;

import java.util.Objects;
import java.util.logging.Logger;

public final class RebornUtilsPaper extends JavaPlugin implements CommandExecutor {
    public Logger logger = this.getLogger();
    private MotdManager motdManager;
    private DiscordBot discordBot;

    @Override
    public void onEnable() {
        logger.info("UtilsPaper is started.");
        Objects.requireNonNull(this.getCommand("me")).setExecutor(new Me());
        Objects.requireNonNull(this.getCommand("try")).setExecutor(new Try());
        this.getServer().getPluginManager().registerEvents(new EventsListener(), this);
        Objects.requireNonNull(this.getCommand("disaster")).setExecutor(new Disaster());
        Objects.requireNonNull(getCommand("minusfps")).setExecutor(new MinusFps());
        ExplodeArrow listener = new ExplodeArrow(this);

        getCommand("giveExplodingArrow").setExecutor(listener);
        getServer().getPluginManager().registerEvents(listener, this);

        motdManager = new MotdManager(getDataFolder());
        Objects.requireNonNull(this.getCommand("togglelink")).setExecutor(motdManager);

        discordBot = new DiscordBot();
        try {
            String discordToken = "token_api";
            discordBot.startBot(discordToken);
            getLogger().info("Discord бот успешно запущен.");
        } catch (Exception e) {
            getLogger().severe("Ошибка при запуске Discord бота: " + e.getMessage());
        }
    }

    @Override
    public void onDisable() {
        logger.info("UtilsPaper is stopped.");
        if (discordBot != null) {
            discordBot.stopBot();
            getLogger().info("Discord бот остановлен.");
        }
    }
}
