package cz.wake.lobby.commands.servers;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import cz.wake.lobby.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("survival2")
@Description("Teleportuje tě na server Survival 1.12")
public class Survival2_command extends BaseCommand {
    @Default
    public void defaultCommand(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Player player = (Player) sender;
        try {
            player.sendMessage("§eTeleportuji na server §fSurvival 1.12");
            Main.getInstance().getCraftBalancerManager().bypassConnect(player, "survival2");
        } catch (Exception e) {
            e.printStackTrace();
            player.sendMessage("§cTeleport na server §fSurvival 1.12 §cse nezdařil!");
        }
    }

    @HelpCommand
    public void helpCommand(CommandHelp help) {
        help.showHelp();
    }
}
