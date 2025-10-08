package ru.komap.rebornUtilsPaper.meteorite;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.util.Random;

public class MeteorCreator {
    public void randomCreateMeteorite(){
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0 :
                createSmallMeteorite();
            case 1 :
                createMediumMeteorite();
            case 2 :
                createBigMeteorite();
        }
    }
    private void createBigMeteorite(Location location) {
        World world = location.getWorld();
    }
    private void createMediumMeteorite(Location location) {
        World world = location.getWorld();
    }
    private void createSmallMeteorite(Location location) {
        World world = location.getWorld();
    }
}
