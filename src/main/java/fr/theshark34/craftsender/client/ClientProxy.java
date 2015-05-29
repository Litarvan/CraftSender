/*
 * Copyright 2015 TheShark34
 *
 * This file is part of CraftSender.
 * CraftSender is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CraftSender is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CraftSender.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.theshark34.craftsender.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import fr.theshark34.craftsender.common.CommonProxy;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        ClientRegistry.registerTileEntity(TileEntityCSModem.class, "tile_cs_modem", new CSModemSpecialRenderer());
    }

}