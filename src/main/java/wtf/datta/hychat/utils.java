package wtf.datta.hychat;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class utils {
    public static String colorize(String text) {
        final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = text.substring(matcher.start(), matcher.end());
            text = text.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            matcher = pattern.matcher(text);
        }

        text = text.replace('&', ChatColor.COLOR_CHAR);
        text = ChatColor.translateAlternateColorCodes('&', text);
        return text;
    }
}
