package cc.co.vijfhoek.basics.threads;

import java.util.*;
import java.util.logging.*;

import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class ThreadReplaceBlocks extends Thread {
	private int blockID;
	private int changeTo;
	private World world;
	private CommandSender sender;
	private Logger log = Logger.getLogger("Minecraft");
	
	public List<Block> foundBlocks = new LinkedList<Block>();
	
	public ThreadReplaceBlocks(int blockID, int changeTo, CommandSender sender, World world) {
		this.blockID = blockID;
		this.changeTo = changeTo;
		this.world = world;
		this.sender = sender;
	}
	
	public void run() {
		int chunkAmount = world.getLoadedChunks().length;
		log("Replacing blockID " + blockID + " with " + changeTo + " in " + chunkAmount + " chunks.");
		Chunk[] chunks = world.getLoadedChunks();
		
		for (int i = 0; i < chunks.length; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i != 0 && i % 1 == 0) {
				log("Replaced " + i + " chunks.");
			}
			Chunk chunk = chunks[i];
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 128; y++) {
					for (int z = 0; z < 16; z++) {
						Block block = chunk.getBlock(x, y, z);
						if (block.getTypeId() == blockID) {
							block.setTypeId(changeTo);
						}
					}
				}
			}
			
		}
		log("Done changing " + chunkAmount + "chunks.");
	}
	
	public void log(String msg) {
		if (sender instanceof Player)
			sender.sendMessage(msg);
		log.info("[Basics] " + msg);
	}
}
