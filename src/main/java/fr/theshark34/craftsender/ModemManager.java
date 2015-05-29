package fr.theshark34.craftsender;

import fr.theshark34.craftsender.client.TileEntityCSModem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ModemManager {

    private static ArrayList<Location> modems = new ArrayList<Location>();

    public static void addModem(TileEntityCSModem modem) {
        modems.add(new Location(modem.xCoord, modem.yCoord, modem.zCoord));
    }

    public static TileEntityCSModem getModem(World world, int x, int y, int z) {
        for(int i = 0; i < modems.size(); i++) {
            Location loc = modems.get(i);
            if (loc.getX() == x && loc.getY() == y && loc.getZ() == z) {
                Location modem = modems.get(i);
                TileEntity te = world.getTileEntity(modem.getX(), modem.getY(), modem.getZ());

                if(te instanceof TileEntityCSModem)
                    return (TileEntityCSModem) te;
                else
                    return null;
            }
        }

        return null;
    }

    public static void deleteModem(TileEntityCSModem modem) {
        for(int i = 0; i < modems.size(); i++) {
            Location loc = modems.get(i);
            if (loc.getX() == modem.xCoord && loc.getY() == modem.yCoord && loc.getZ() == modem.zCoord)
                modems.remove(i);
        }

    }

}
