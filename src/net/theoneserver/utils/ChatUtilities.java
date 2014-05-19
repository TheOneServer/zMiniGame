/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.theoneserver.utils;

import static org.bukkit.ChatColor.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
        
/**
 *
 * @author Joe
 */
public class ChatUtilities {
    
    public static void broadcast(String msg) {
        for(Player player : Bukkit.getOnlinePlayers())
            player.sendMessage(starter() + msg);
    }
    
    private static String starter() {
        return DARK_GRAY + "[" + RED + "zMiniGame" + DARK_GRAY + "] " 
                + WHITE;
    }
}
