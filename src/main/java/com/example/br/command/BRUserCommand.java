package com.example.br.command;

import com.example.br.BattleRoyale;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BRUserCommand implements CommandExecutor {

    private final BattleRoyale plugin;

    public BRUserCommand(BattleRoyale plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("Only players.");
            return true;
        }

        if (args.length == 0) {
            help(p);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "help" -> help(p);
            case "join" -> {
                if (args.length < 2) {
                    p.sendMessage(Component.text("§cاستفاده: /bruser join <arena>", NamedTextColor.RED));
                } else {
                    p.sendMessage(Component.text("§aدر حال ورود به «" + args[1] + "»... (به زودی)", NamedTextColor.GREEN));
                }
            }
            case "leave" -> p.sendMessage(Component.text("§aاز لابی خارج شدی (به زودی)", NamedTextColor.GREEN));
            case "stats" -> p.sendMessage(Component.text("§7آمار شما (به زودی)", NamedTextColor.GRAY));
            case "top" -> p.sendMessage(Component.text("§7رتبه‌بندی (به زودی)", NamedTextColor.GRAY));
            default -> p.sendMessage(Component.text("§cدستور ناشناخته. /bruser help", NamedTextColor.RED));
        }
        return true;
    }

    private void help(Player p) {
        p.sendMessage(Component.text("§6§l=== BRLobby ===", NamedTextColor.GOLD));
        p.sendMessage(Component.text("§e/bruser join <arena> §7- ورود به لابی", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/bruser leave §7- خروج", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/bruser stats §7- آمار", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/bruser top §7- رتبه‌بندی", NamedTextColor.YELLOW));
    }
}
