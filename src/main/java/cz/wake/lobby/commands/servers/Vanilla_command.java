package cz.wake.lobby.commands.servers;

import cz.wake.lobby.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanilla_command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command Command, String String, String[] ArrayOfString) {
        if (Sender instanceof Player) {
            Player player = (Player) Sender;
            if ((Command.getName().equalsIgnoreCase("vanilla"))) {
                try {
                    player.sendMessage("§eTeleportuji na server §fVanilla");
                    Main.getInstance().getCraftBalancerManager().bypassConnect(player, "vanilla");
                } catch (Exception e) {
                    e.printStackTrace();
                    player.sendMessage("§cTeleport na server §fVanilla §cse nezdaril!");
                }
            }
        }
        return false;
    }
}
