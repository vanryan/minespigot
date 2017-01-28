package com.vr.trPlugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

public final class EventListener implements Listener{

    public int i = 0;
    public int j = 1;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(event.getPlayer().getName() + " Welcome to VR's MC! Yoooo!");

        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();

        PlayerInventory inventory = player.getInventory();


        /*

        // Every time a player joins, give something or spawn some creatures

        ItemStack itemstack = new ItemStack(Material.DIAMOND_SWORD);
        inventory.addItem(itemstack);


        Chicken bornChicken = world.spawn(loc, Chicken.class);

        Location newloc = new Location(world, loc.getX(), loc.getY()+10, loc.getZ());
        player.playSound(newloc, Sound.BLOCK_GRAVEL_BREAK, 10, 5);

        for (int i = 0; i < DyeColor.values().length; i++) {
            Sheep sheep = world.spawn(loc, Sheep.class);
            sheep.setColor(DyeColor.values()[i]);
            //sheep.setAI(true);
            //Cow cow = world.spawn(loc, Cow.class);
            //cow.setAI(true);
        }


         */
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        /*

        // spawn stuff after move for a certain amount

        i++;

        if (i% 75 == 0) {
            Player player = event.getPlayer();
            Location loc = player.getLocation();
            World world = player.getWorld();
            Pig pig = world.spawn(loc, Pig.class);
            Sheep sheep = world.spawn(loc, Sheep.class);
            sheep.setColor(DyeColor.values()[j]);

            j++;
            if (j % 16 == 0)
                j = 0;

            i = 0;
        }
         */
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        /*
        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = player.getWorld();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) && event.getMaterial() == Material.STICK) {
            World w = player.getWorld();
            Sheep sheep = w.spawn(loc, Sheep.class);
        }
         */

        /*
        // falling apple
        if(event.getAction().equals(Action.LEFT_CLICK_AIR)){
            FallingBlock block = event.getPlayer().getWorld().spawnFallingBlock(event.getPlayer().getLocation(), Material.APPLE, (byte) 0);
            float x = -1 + (float) (Math.random() * ((1 - -1) + 1));
            float y = -5 + (float)(Math.random() * ((5 - -5) + 1));
            float z = (float) -0.3 + (float)(Math.random() * ((0.3 - -0.3) + 1));
            Bukkit.broadcastMessage("§c" + x + ", §a" + y + ", §d" + z);
            block.setVelocity(new Vector(x, y, z));
        }
         */
    }
}
