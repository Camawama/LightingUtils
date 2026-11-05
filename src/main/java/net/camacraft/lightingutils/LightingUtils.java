package net.camacraft.lightingutils;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import org.slf4j.Logger;

@Mod(LightingUtils.MODID)
public class LightingUtils
{
    public static final String MODID = "lightingutils";
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Bump when the tinted glass block states change (they are what must match on both sides).
     */
    private static final String PRESENCE_VERSION = "1";

    public LightingUtils(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // The POWER property adds 15 states to vanilla tinted glass, which shifts every block state
        // id registered after it, so a client and a server that disagree about this mod see each
        // other's worlds garbled. This channel carries no messages: being strict (neither side
        // accepts the other lacking it), it makes Forge refuse such a login with a mod-mismatch
        // screen, and marks the server incompatible in the server list.
        NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, "presence"),
                () -> PRESENCE_VERSION, PRESENCE_VERSION::equals, PRESENCE_VERSION::equals);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
