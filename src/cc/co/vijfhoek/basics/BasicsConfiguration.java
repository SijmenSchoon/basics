package cc.co.vijfhoek.basics;

import java.io.*;

import org.bukkit.util.config.Configuration;

public class BasicsConfiguration {
	private File fleConfig;
	private File fleConfigDir;
	private String strConfigType;
	
	public BasicsConfiguration(String configType) {
		fleConfigDir = new File("plugins" + File.separator + "Basics");
		
		if(configType.equals("config")) {
			fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "config.yml");
			strConfigType = configType;
		} else if(configType.equals("items")) {
			fleConfig = new File("plugins" + File.separator + "Basics" + File.separator + "items.yml");
			strConfigType = configType;
		}
	}
	
	public Configuration getConfiguration() {
		Configuration config = new Configuration(fleConfig);
		return config;
	}
	
	public String convertStreamToString(InputStream is) {
		if (is == null) {
			return "";
		}
		
		Writer writer = new StringWriter();
		char[] buffer = new char[1024];
		try {
			Reader reader = new BufferedReader(new InputStreamReader(is));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	
	public void createIfNotExists() {
		fleConfigDir.mkdirs();
		if(!fleConfig.exists()) {
			try {
				fleConfig.createNewFile();
				PrintWriter prwConfig = new PrintWriter(fleConfig);
				String configString;
				if(strConfigType.equals("config")) {
					InputStream isConfig = Basics.class.getResourceAsStream("/config.yml");
					configString = convertStreamToString(isConfig);
				} else if(strConfigType.equals("items")) {
					configString = 
						"stone: 1\r\n" +
						"cleanstone: 1\r\n" +
						"grass: 2\r\n" +
						"dirt: 3\r\n" +
						"cobblestone: 4\r\n" +
						"cobble: 4\r\n" +
						"woodenplank: 5\r\n" +
						"wood: 5\r\n" +
						"plank: 5\r\n" +
						"sapling: 6\r\n" +
						"sprucesapling: 6|1\r\n" +
						"birchsapling: 6|2\r\n" +
						"bedrock: 7\r\n" +
						"adminium: 7\r\n" +
						"water: 8\r\n" +
						"stillwater: 9\r\n" +
						"lava: 10\r\n" +
						"stilllava: 11\r\n" +
						"sand: 12\r\n" +
						"gravel: 13\r\n" +
						"goldore: 14\r\n" +
						"gore: 14\r\n" +
						"ironore: 15\r\n" +
						"iore: 15\r\n" +
						"coalore: 16\r\n" +
						"core: 16\r\n" +
						"log: 17\r\n" +
						"oakwood: 17\r\n" +
						"pinelog: 17|1\r\n" +
						"pinewood: 17|1\r\n" +
						"birchlog: 17|2\r\n" +
						"birchwood: 17|2\r\n" +
						"leaves: 18\r\n" +
						"sponge: 19\r\n" +
						"glass: 20\r\n" +
						"lapislazuliore: 21\r\n" +
						"llore: 21\r\n" +
						"lore: 21\r\n" +
						"lapislazuliblock: 22\r\n" +
						"llblock: 22\r\n" +
						"lblock: 22\r\n" +
						"dispenser: 23\r\n" +
						"sandstone: 24\r\n" +
						"noteblock: 25\r\n" +
						"bedblock: 26\r\n" +
						"poweredrail: 27\r\n" +
						"prail: 27\r\n" +
						"detectorrail: 28\r\n" +
						"stickypiston: 29\r\n" +
						"web: 30\r\n" +
						"tallgrass: 31\r\n" +
						"deadshrubs: 32\r\n" +
						"shrubs: 32\r\n" +
						"piston: 33\r\n" +
						"wool: 35\r\n" +
						"orangewool: 35|1\r\n" +
						"magentawool: 35|2\r\n" +
						"lightbluewool: 35|3\r\n" +
						"yellowwool: 35|4\r\n" +
						"lightgreenwool: 35|5\r\n" +
						"pinkwool: 35|6\r\n" +
						"graywool: 35|7\r\n" +
						"lightgraywool: 35|8\r\n" +
						"cyanwool: 35|9\r\n" +
						"purplewool: 35|10\r\n" +
						"bluewool: 35|11\r\n" +
						"brownwool: 35|12\r\n" +
						"greenwool: 35|13\r\n" +
						"redwool: 35|14\r\n" +
						"blackwool: 35|15\r\n" +
						"yellowflower: 37\r\n" +
						"redrose: 28\r\n" +
						"brownmushroom: 39\r\n" +
						"redmushroom: 40\r\n" +
						"goldblock: 41\r\n" +
						"gblock: 41\r\n" +
						"ironblock: 42\r\n" +
						"iblock: 42\r\n" +
						"doubleslab: 43\r\n" +
						"doublestoneslab: 43\r\n" +
						"doublesandstoneslab: 43|1\r\n" +
						"doublesandslab: 43|1\r\n" +
						"doublewoodenslab: 43|2\r\n" +
						"doublecobblestoneslab: 43|3\r\n" +
						"doublecobbleslab: 43|3\r\n" +
						"stoneslab: 44\r\n" +
						"slab: 44\r\n" +
						"sandstoneslab: 44|1\r\n" +
						"sandslab: 44|1\r\n" +
						"woodenslab: 44|2\r\n" +
						"cobblestoneslab: 44|3\r\n" +
						"brickblock: 45\r\n" +
						"tnt: 46\r\n" +
						"dynamite: 46\r\n" +
						"bomb: 46\r\n" +
						"bookshelf: 47\r\n" +
						"mossstone: 48\r\n" +
						"mossystone: 48\r\n" +
						"mossycobblestone: 48\r\n" +
						"mossycobble: 48\r\n" +
						"obsidian: 49\r\n" +
						"torch: 50\r\n" +
						"lamp: 50\r\n" +
						"light: 50\r\n" +
						"fire: 51\r\n" +
						"monsterspawner: 52\r\n" +
						"pigspawner: 52\r\n" +
						"mobspawner: 52\r\n" +
						"woodenstairs: 53\r\n" +
						"wstairs: 53\r\n" +
						"woodstairs: 53\r\n" +
						"chest: 54\r\n" +
						"box: 54\r\n" +
						"redstonewire: 55\r\n" +
						"diamondore: 56\r\n" +
						"dore: 56\r\n" +
						"diamondblock: 57\r\n" +
						"dblock: 57\r\n" +
						"craftingtable: 58\r\n" +
						"craftinggrid: 58\r\n" +
						"workbench: 58\r\n" +
						"crops: 59\r\n" +
						"farmland: 60\r\n" +
						"tilleddirt: 60\r\n" +
						"furnace: 61\r\n" +
						"oven: 61\r\n" +
						"burningfurnace: 62\r\n" +
						"burningoven: 62\r\n" +
						"signpost: 63 #This is the block, not the item you probably want\r\n" +
						"woodendoorblock: 64\r\n" +
						"wooddoorblock: 64\r\n" +
						"wdoorblock: 64\r\n" +
						"ladder: 65\r\n" +
						"rails: 66\r\n" +
						"track: 66\r\n" +
						"cobblestonestairs: 67\r\n" +
						"cobblestairs: 67\r\n" +
						"stonestairs: 67\r\n" +
						"cstairs: 67\r\n" +
						"sstairs: 67\r\n" +
						"wallsign: 68\r\n" +
						"lever: 69\r\n" +
						"switch: 69\r\n" +
						"stonepressureplate: 70\r\n" +
						"spressureplate: 70\r\n" +
						"splate: 70\r\n" +
						"irondoorblock: 71\r\n" +
						"idoorblock: 71\r\n" +
						"woodenpressureplate: 72\r\n" +
						"wpressureplate: 72\r\n" +
						"wplate: 72\r\n" +
						"redstoneore: 73\r\n" +
						"rore: 73\r\n" +
						"glowingredstoneore: 74\r\n" +
						"glowingrore: 74\r\n" +
						"grore: 74\r\n" +
						"redstonetorchoff: 75\r\n" +
						"rstorchoff: 75\r\n" +
						"redstonetorch: 76\r\n" +
						"rstorch: 76\r\n" +
						"redstonetorchon: 76\r\n" +
						"rstorchon: 76\r\n" +
						"stonebutton: 77\r\n" +
						"button: 77\r\n" +
						"btn: 77\r\n" +
						"sbutton: 77\r\n" +
						"snow: 78\r\n" +
						"ice: 79\r\n" +
						"snowblock: 80\r\n" +
						"sblock: 80\r\n" +
						"cactus: 81\r\n" +
						"cacti: 81\r\n" +
						"clayblock: 82\r\n" +
						"cblock: 82\r\n" +
						"sugarcaneblock: 83\r\n" +
						"reedblock: 83\r\n" +
						"jukebox: 84\r\n" +
						"fence: 85\r\n" +
						"pumpkin: 86\r\n" +
						"netherrack: 87\r\n" +
						"netherrock: 87\r\n" +
						"soulsand: 88\r\n" +
						"glowstone: 89\r\n" +
						"glowstoneblock: 89\r\n" +
						"gsblock: 89\r\n" +
						"portal: 90\r\n" +
						"jackolantern: 91\r\n" +
						"cakeblock: 92\r\n" +
						"redstonerepeateroff: 93\r\n" +
						"diodeoff: 93\r\n" +
						"repeateroff: 93\r\n" +
						"redstonerepeateron: 94\r\n" +
						"diodeon: 94\r\n" +
						"repeateron: 94\r\n" +
						"lockedchest: 95\r\n" +
						"lchest: 95\r\n" +
						"trapdoor: 96\r\n" +
						"hatch: 96\r\n" +
						"\r\n" +
						"ironshovel: 256\r\n" +
						"ishovel: 256\r\n" +
						"ironpickaxe: 257\r\n" +
						"ipickaxe: 257\r\n" +
						"ironpick: 257\r\n" +
						"ipick: 257\r\n" +
						"ironaxe: 258\r\n" +
						"iaxe: 258\r\n" +
						"flintandsteel: 259\r\n" +
						"lighter: 259\r\n" +
						"apple: 260\r\n" +
						"bow: 261\r\n" +
						"arrow: 262\r\n" +
						"coal: 263\r\n" +
						"charcoal: 263|1\r\n" +
						"diamond: 264\r\n" +
						"iron: 265\r\n" +
						"ironingot: 265\r\n" +
						"iingot: 265\r\n" +
						"ironbar: 265\r\n" +
						"ibar: 265\r\n" +
						"gold: 266\r\n" +
						"goldingot: 266\r\n" +
						"gingot: 266\r\n" +
						"gbar: 266\r\n" +
						"ironsword: 267\r\n" +
						"isword: 267\r\n" +
						"woodensword: 268\r\n" +
						"wsword: 268\r\n" +
						"woodenshovel: 269\r\n" +
						"wshovel: 269\r\n" +
						"woodenpickaxe: 270\r\n" +
						"wpickaxe: 270\r\n" +
						"wpick: 270\r\n" +
						"woodenaxe: 271\r\n" +
						"waxe: 271\r\n" +
						"stonesword: 272\r\n" +
						"ssword: 272\r\n" +
						"stoneshovel: 273\r\n" +
						"sshovel: 273\r\n" +
						"stonepickaxe: 274\r\n" +
						"stonepick: 274\r\n" +
						"spickaxe: 274\r\n" +
						"spick: 274\r\n" +
						"stoneaxe: 275\r\n" +
						"saxe: 275\r\n" +
						"diamondsword: 276\r\n" +
						"dsword: 276\r\n" +
						"diamondshovel: 277\r\n" +
						"dshovel: 277\r\n" +
						"diamondpickaxe: 278\r\n" +
						"diamondpick: 278\r\n" +
						"dpickaxe: 278\r\n" +
						"dpick: 278\r\n" +
						"diamondaxe: 279\r\n" +
						"daxe: 279\r\n" +
						"stick: 280\r\n" +
						"bowl: 281\r\n" +
						"mushroomsoup: 282\r\n" +
						"mushroomstew: 282\r\n" +
						"goldsword: 283\r\n" +
						"gsword: 283\r\n" +
						"goldshovel: 284\r\n" +
						"gshovel: 284\r\n" +
						"goldpickaxe: 285\r\n" +
						"goldpick: 285\r\n" +
						"gpickaxe: 285\r\n" +
						"gpick: 285\r\n" +
						"goldaxe: 286\r\n" +
						"gaxe: 286\r\n" +
						"string: 287\r\n" +
						"feather: 288\r\n" +
						"gunpowder: 289\r\n" +
						"sulphur: 289\r\n" +
						"woodenhoe: 290\r\n" +
						"whoe: 290\r\n" +
						"stonehoe: 291\r\n" +
						"shoe: 291\r\n" +
						"ironhoe: 292\r\n" +
						"ihoe: 292\r\n" +
						"diamondhoe: 293\r\n" +
						"dhoe: 293\r\n" +
						"goldhoe: 294\r\n" +
						"ghoe: 294\r\n" +
						"seeds: 295\r\n" +
						"seed: 295\r\n" +
						"wheat: 296\r\n" +
						"weed: 296 #Just for da lulz\r\n" +
						"bread: 297\r\n" +
						"leatherhelmet: 298\r\n" +
						"leatherhat: 298\r\n" +
						"lhelmet: 298\r\n" +
						"lhat: 298\r\n" +
						"leatherchestplate: 299\r\n" +
						"leathershirt: 299\r\n" +
						"lchestplate: 299\r\n" +
						"lshirt: 299\r\n" +
						"leatherleggings: 300\r\n" +
						"leatherpants: 300\r\n" +
						"lleggings: 300\r\n" +
						"lpants: 300\r\n" +
						"leatherboots: 301\r\n" +
						"leathershoes: 301\r\n" +
						"lboots: 301\r\n" +
						"lshoes: 301\r\n" +
						"chainmailhelmet: 302\r\n" +
						"chainmailhat: 302\r\n" +
						"chelmet: 302\r\n" +
						"chat: 302\r\n" +
						"chainmailchestplate: 303\r\n" +
						"chainmailshirt: 303\r\n" +
						"cchestplate: 303\r\n" +
						"cshirt: 303\r\n" +
						"chainmailleggins: 304\r\n" +
						"chainmailpants: 304\r\n" +
						"cleggins: 304\r\n" +
						"cpants: 304\r\n" +
						"chainmailboots: 305\r\n" +
						"chainmailshoes: 305\r\n" +
						"cboots: 305\r\n" +
						"cshoes: 305\r\n" +
						"ironhelmet: 306\r\n" +
						"ironhat: 306\r\n" +
						"ihelmet: 306\r\n" +
						"ihat: 306\r\n" +
						"ironchestplate: 307\r\n" +
						"ironshirt: 307\r\n" +
						"ichestplate: 307\r\n" +
						"ishirt: 307\r\n" +
						"ironleggins: 308\r\n" +
						"ironpants: 308\r\n" +
						"ileggins: 308\r\n" +
						"ipants: 308\r\n" +
						"ironboots: 309\r\n" +
						"ironshoes: 309\r\n" +
						"iboots: 309\r\n" +
						"ishoes: 309\r\n" +
						"diamondhelmet: 310\r\n" +
						"diamondhat: 310\r\n" +
						"dhelmet: 310\r\n" +
						"dhat: 310\r\n" +
						"diamondchestplate: 311\r\n" +
						"diamondshirt: 311\r\n" +
						"dchestplate: 311\r\n" +
						"dshirt: 311\r\n" +
						"diamondleggins: 312\r\n" +
						"diamondpants: 312\r\n" +
						"dleggins: 312\r\n" +
						"dpants: 312\r\n" +
						"diamondboots: 313\r\n" +
						"diamondshoes: 313\r\n" +
						"dboots: 313\r\n" +
						"dshoes: 313\r\n" +
						"goldhelmet: 314\r\n" +
						"goldhat: 314\r\n" +
						"ghelmet: 314\r\n" +
						"ghat: 314\r\n" +
						"goldchestplate: 315\r\n" +
						"goldshirt: 315\r\n" +
						"gchestplate: 315\r\n" +
						"gshirt: 315\r\n" +
						"goldleggins: 316\r\n" +
						"goldpants: 316\r\n" +
						"gleggins: 316\r\n" +
						"gpants: 316\r\n" +
						"goldboots: 317\r\n" +
						"goldshoes: 317\r\n" +
						"gboots: 317\r\n" +
						"gshoes: 317\r\n" +
						"flint: 318\r\n" +
						"rawporkchop: 319\r\n" +
						"porkchop: 319\r\n" +
						"rawbacon: 319\r\n" +
						"bacon: 319" +
						"cookedporkchop: 320\r\n" +
						"cookedbacon: 320\r\n" +
						"paintings: 321\r\n" +
						"painting: 321\r\n" +
						"goldenapple: 322\r\n" +
						"gapple: 322\r\n" +
						"sign: 323\r\n" +
						"woodendoor: 324\r\n" +
						"wdoor: 324\r\n" +
						"bucket: 325\r\n" +
						"emptybucket: 325\r\n" +
						"waterbucket: 326\r\n" +
						"lavabucket: 327\r\n" +
						"minecart: 328\r\n" +
						"saddle: 329\r\n" +
						"irondoor: 330\r\n" +
						"idoor: 330\r\n" +
						"redstone: 331\r\n" +
						"redstonedust: 331\r\n" +
						"snowball: 332\r\n" +
						"boat: 333\r\n" +
						"leather: 334\r\n" +
						"milkbucket: 335\r\n" +
						"milk: 335\r\n" +
						"claybrick: 336\r\n" +
						"clayballs: 337\r\n" +
						"clayball: 337\r\n" +
						"clay: 337\r\n" +
						"sugarcane: 338\r\n" +
						"reed: 338\r\n" +
						"paper: 339\r\n" +
						"book: 340\r\n" +
						"slimeball: 341\r\n" +
						"slime: 341\r\n" +
						"storageminecart: 342\r\n" +
						"storagecart: 342\r\n" +
						"poweredminecart: 343\r\n" +
						"poweredcart: 343\r\n" +
						"egg: 344\r\n" +
						"compass: 345\r\n" +
						"fishingrod: 346\r\n" +
						"clock: 347\r\n" +
						"glowstonedust: 348\r\n" +
						"glowdust: 348\r\n" +
						"rawfish: 349\r\n" +
						"fish: 349\r\n" +
						"cookedfish: 350\r\n" +
						"inksac: 351\r\n" +
						"blackdye: 351\r\n" +
						"rosered: 351|1\r\n" +
						"reddye: 351|1\r\n" +
						"cactusgreen: 351|2\r\n" +
						"greendye: 351|2\r\n" +
						"cocoabeans: 351|3\r\n" +
						"browndye: 351|3\r\n" +
						"lapislazuli: 351|4\r\n" +
						"bluedye: 351|4\r\n" +
						"purpledye: 351|5\r\n" +
						"cyandye: 351|6\r\n" +
						"lightgraydye: 351|7\r\n" +
						"graydye: 351|8\r\n" +
						"pinkdye: 351|9\r\n" +
						"limedye: 351|10\r\n" +
						"dandelionyellow: 351|11\r\n" +
						"yellowdye: 351|11\r\n" +
						"lightbluedye: 351|12\r\n" +
						"magentadye: 351|13\r\n" +
						"orangedye: 351|14\r\n" +
						"bonemeal: 351|15\r\n" +
						"whitedye: 351|15\r\n" +
						"bone: 352\r\n" +
						"sugar: 353\r\n" +
						"cake: 354\r\n" +
						"bed: 355\r\n" +
						"redstonerepeater: 356\r\n" +
						"rsrepeater: 356\r\n" +
						"diode: 356\r\n" +
						"goldmusicdisk: 2256\r\n" +
						"goldrecord: 2256\r\n" +
						"golddisk: 2256\r\n" +
						"gmusicdisk: 2256\r\n" +
						"grecord: 2256\r\n" +
						"gdisk: 2256\r\n" +
						"greenmusicdisk: 2257\r\n" +
						"greenrecord: 2257\r\n" +
						"greendisk: 2257\r\n" +
						"gmusicdisk: 2257\r\n" +
						"grecord: 2257\r\n" +
						"gdisk: 2257\r\n";
				} else {
					configString = "";
				}
				
				prwConfig.write(configString);
				prwConfig.flush();
				prwConfig.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
