package com.example.br;

import com.example.br.command.BRCommand;
import com.example.br.command.BRUserCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class BattleRoyale extends JavaPlugin {

    private static BattleRoyale instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // ثبت کامندها
        getCommand("br").setExecutor(new BRCommand(this));
        getCommand("bruser").setExecutor(new BRUserCommand(this));

        getLogger().info("BRLobby enabled! (Step 1 - with commands)");
    }

    @Override
    public void onDisable() {
        getLogger().info("BRLobby disabled!");
    }

    public static BattleRoyale getInstance() { return instance; }
}
