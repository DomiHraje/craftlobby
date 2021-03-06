package cz.wake.lobby.listeners;

import cz.wake.lobby.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        try {
            if (event.getCurrentItem() == null) {
                return;
            }
            //**************************** SERVERS MENU ****************************//
            if (event.getView().getTitle().equals("Vyber serveru")) {
                if (event.getSlot() == 10) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "survival");
                }
                if (event.getSlot() == 11) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "skyblock");
                }
                if (event.getSlot() == 12) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative");
                }
                if (event.getSlot() == 15) {
                    if (event.isLeftClick()) {
                        Main.getInstance().getCraftBalancerManager().connectPlayer(player, "halloween-games");
                    } else if (event.isRightClick()) {
                        player.closeInventory();
                        player.sendMessage("");
                        player.sendMessage("§c▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                        player.sendMessage("");
                        player.sendMessage("");
                        player.sendMessage("§6Odkaz na Halloween Leaderboard:");
                        player.sendMessage("§bhttps://stats.craftmania.cz/leaderboard/halloween");
                        player.sendMessage("");
                        player.sendMessage("§c▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                        player.sendMessage("");
                    }
                }
                if (event.getSlot() == 13) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla");
                }
                if (event.getSlot() == 22) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla2");
                }
                if (event.getSlot() == 16) {
                    player.sendMessage("§c§l[!] §cServer se aktualne predelava... O dalsich novinkach se brzo dozvis.");
                }
                if (event.getSlot() == 21) {
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "creative2");
                }
            }
            if ((event.getSlot() == 19) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Web"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš web:");
                player.sendMessage("§fhttps://craftmania.cz");
                player.sendMessage("");
                player.sendMessage("§a▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 21) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Discord"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš Discord server:");
                player.sendMessage("§fhttps://discord.gg/craftmania");
                player.sendMessage("");
                player.sendMessage("§9▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 23) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Facebook"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na naší Facebook page:");
                player.sendMessage("§fhttps://www.fb.com/craftmaniacz/");
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
            if ((event.getSlot() == 25) && (event.getCurrentItem().getItemMeta().getDisplayName().contains("Instagram"))) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 13.0F, 1.0F);
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.sendMessage("");
                player.sendMessage("§eOdkaz na náš Instagram účet:");
                player.sendMessage("§fhttps://www.instagram.com/craftmania.cz/");
                player.sendMessage("");
                player.sendMessage("§b▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃▃");
                player.sendMessage("");
                player.closeInventory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
