package de.vepexlegit.safewalkdebug;

import de.vepexlegit.safewalkdebug.commands.*;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "safewalkdebug", version = "1.0")
public class SafeWalkDebug {
    public static boolean safewalk = false;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new SafeWalkCommand());
    }

    @SubscribeEvent
    public void onUpdate(LivingEvent.LivingUpdateEvent event) {
        try {
            safewalk = true;
        } catch (Exception e) {
            safewalk = false;
        }
    }
}
