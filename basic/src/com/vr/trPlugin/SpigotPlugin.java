package com.vr.trPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class SpigotPlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        System.out.println("[vrPlugin] enabled trPlugin");
        getLogger().info("[vrPluginLogger] here we are");

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            getLogger().info(player.getName());
        }

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable(){
        System.out.println("[vrPlugin] disabled trPlugin");
    }

    //  boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        World world = player.getWorld();
        if (label.equalsIgnoreCase("vtp")) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.DARK_AQUA + "TOO FEW ARGUMENTS");
            } else {

                Map<String, List<Location>> multiBook = new HashMap<String, List<Location>>();
                Map<String, Location> viewPoints = new HashMap<String, Location>();

                /* Locations */
                long[] worldSeeds = new long[3];
                worldSeeds[0] = -2220761984050473603L;

                getLogger().info(Long.toString(world.getSeed()));

                if (world.getSeed() == worldSeeds[0]) {
                    List<Location> homes = new ArrayList<Location>();
                    homes.add(new Location(world, -46.874, 96, 2.993));
                    homes.add(new Location(world, -250, 65, 46.564));

                    List<Location> walls = new ArrayList<Location>();
                    walls.add(new Location(world, -51.217, 88, 183.087));

                    List<Location> villages = new ArrayList<Location>();
                    villages.add(new Location(world, -357, 65, 127));


                    viewPoints.put("skyisland", new Location(world, -79, 125, -70.163));
                    viewPoints.put("home",  homes.get(0));
                    viewPoints.put("wall", walls.get(0));
                    viewPoints.put("village", villages.get(0));


                    multiBook.put("home", homes);
                    multiBook.put("wall", walls);
                    multiBook.put("village", villages);
                }

                // default location
                Location defaultLoc = new Location(world, -250, 65, 46.564);

                if (args.length == 1) {
                    String arg0 = args[0].toLowerCase();

                    if (viewPoints.containsKey(arg0)) {
                        player.teleport(viewPoints.get(arg0));
                    } else {
                        player.teleport(defaultLoc);
                    }
                }
                if (args.length > 1) {
                    String arg0 = args[0].toLowerCase();
                    if (multiBook.containsKey(arg0)) {
                        try {
                            String pattern = "\\d+";
                            Pattern r = Pattern.compile(pattern);
                            Matcher m = r.matcher(args[1]);
                            if (m.find()) {
                                player.teleport(multiBook.get(arg0).get(Integer.parseInt(m.group(0))));
                            } else {
                                player.teleport(defaultLoc);
                            }
                        } catch(Exception e) {
                            System.err.println(e.getMessage());
                            player.teleport(defaultLoc);
                        }
                    } else {
                        player.teleport(defaultLoc);
                    }
                }


            }
            return true;
        }
        return false;
    }
}
