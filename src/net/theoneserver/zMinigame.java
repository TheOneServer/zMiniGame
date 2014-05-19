/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.theoneserver;
import net.theoneserver.handlers.StartCountdown;
import org.bukkit.plugin.java.JavaPlugin;

public class zMinigame extends JavaPlugin {
    
    public void onEnable(){
        new Thread((Runnable) new StartCountdown()).start();
        
        GameState.setstate(GameState.IN_LOBBY);
        

    }
    
    public static void start() {
        
    }
    
    public static void stop(){
        
    }

    public static boolean canStart() {
    	
    	
    	return false;
    }
    
}
