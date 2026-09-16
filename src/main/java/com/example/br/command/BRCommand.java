package com.example.br.command;

import com.example.br.BattleRoyale;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BRCommand implements CommandExecutor {

    private final BattleRoyale plugin;

    public BRCommand(BattleRoyale plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("Only players.");
            return true;
        }

        if (!p.hasPermission("br.admin") && !p.isOp()) {
            p.sendMessage(Component.text("§cشما دسترسی ادمین ندارید.", NamedTextColor.RED));
            return true;
        }

        if (args.length == 0) {
            help(p);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "help" -> help(p);
            case "reload" -> {
                plugin.reloadConfig();
                p.sendMessage(Component.text("§aکانفیگ ری‌لود شد.", NamedTextColor.GREEN));
            }
            case "create" -> {
                if (args.length < 2) {
                    p.sendMessage(Component.text("§cاستفاده: /br create <arena>", NamedTextColor.RED));
                } else {
                    p.sendMessage(Component.text("§aآرنا «" + args[1] + "» ساخته شد (به زودی)", NamedTextColor.GREEN));
                }
            }
            case "delete" -> {
                if (args.length < 2) {
                    p.sendMessage(Component.text("§cاستفاده: /br delete <arena>", NamedTextColor.RED));
                } else {
                    p.sendMessage(Component.text("§aآرنا «" + args[1] + "» حذف شد (به زودی)", NamedTextColor.GREEN));
                }
            }
            case "list" -> p.sendMessage(Component.text("§7لیست آرناها (به زودی)", NamedTextColor.GRAY));
            case "start" -> p.sendMessage(Component.text("§eشروع بازی (به زودی)", NamedTextColor.YELLOW));
            case "stop" -> p.sendMessage(Component.text("§eتوقف بازی (به زودی)", NamedTextColor.YELLOW));
            default -> p.sendMessage(Component.text("§cدستور ناشناخته. /br help", NamedTextColor.RED));
        }
        return true;
    }

    private void help(Player p) {
        p.sendMessage(Component.text("§6§l=== BRLobby Admin ===", NamedTextColor.GOLD));
        p.sendMessage(Component.text("§e/br help §7- راهنما", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br create <arena> §7- ساخت آرنا", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br delete <arena> §7- حذف آرنا", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br list §7- لیست آرناها", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br start §7- شروع بازی", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br stop §7- توقف", NamedTextColor.YELLOW));
        p.sendMessage(Component.text("§e/br reload §7- ری‌لود کانفیگ", NamedTextColor.YELLOW));
    }
}
