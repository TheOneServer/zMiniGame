/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.theoneserver.handlers;

import net.theoneserver.GameState;
import net.theoneserver.zMinigame;
import org.bukkit.Bukkit;
import net.theoneserver.utils.ChatUtilities;
import net.theoneserver.zMinigame;
/**
 *
 * @author Joe
 */
public class StartCountdown implements Runnable {
	private static int timeUntilStart;

	public void run(){
		timeUntilStart = 60;
		while (true) {
			if(GameState.isState(GameState.IN_LOBBY))
				if(zMinigame.canStart()){
					timeUntilStart = 60;
					ChatUtilities.broadcast("Minimum players reached! Countdown starting!");
					for(;timeUntilStart >= 0; timeUntilStart--){
						if(!zMinigame.canStart()){
							ChatUtilities.broadcast("Not enough players needed to start! Countdown stopped!");
							break;
						}
						
						if(timeUntilStart == 0) {
							zMinigame.start();
							break;
						}  

						if(timeUntilStart % 10==0 || timeUntilStart < 10){
							ChatUtilities.broadcast(timeUntilStart + 
									" seconds until the game starts!");
						}

						try{
							Thread.sleep(1000);
						}catch(InterruptedException e){
							e.printStackTrace();
							Bukkit.shutdown();
						}
					}
				}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
				Bukkit.shutdown();
			}
		}
	}
}
