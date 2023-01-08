package wtf.datta.hychat;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static wtf.datta.hychat.utils.colorize;

public final class HyChat extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("&a| HyChat ha cargado correctamente!");
    }
    @EventHandler
    public void chatSetup(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();
        String prefix = PlaceholderAPI.setPlaceholders(player,"%vault_prefix%");
        String nick = PlaceholderAPI.setPlaceholders(player,"%player_name%");

        event.setFormat(colorize
                (" "+prefix+nick+" &8» #b5b5b5"+message));
    }
}
