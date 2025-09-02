package dev.waterchick.antiunicode;

import dev.waterchick.antiunicode.managers.CharManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listener implements org.bukkit.event.Listener {

    private final CharManager charManager;

    public Listener(CharManager charManager){
        this.charManager = charManager;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        message = charManager.removeChars(message);
        if(message.isEmpty() || message.isBlank()) {
            event.setCancelled(true);
            return;
        }
        event.setMessage(message);
    }
}
