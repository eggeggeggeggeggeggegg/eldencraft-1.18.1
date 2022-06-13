package net.bells.eldencraft;

import net.bells.eldencraft.structure.EldenStructures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EldenCraft.MOD_ID)
public class EldenCraft
{
    // Directly reference a log4j logger.
    public static final String MOD_ID = "eldencraft";
    public static final Logger LOGGER = LogManager.getLogger();


    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String pId, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pId, pConfiguredFeature);
    }

    public EldenCraft() {
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //listen up
        modEventBus.addListener(this::setup);


        EldenStructures.register(modEventBus);
        //frog bus
        IEventBus frogBus = MinecraftForge.EVENT_BUS;

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());



        //event.enqueueWork(() -> {
        //    EldenStructures.setupStructures();
        //    EldenConfiguredStructures.registerConfiguredStructures();
        //});
    }
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent playerEvent) {
            Player player = playerEvent.player;
            //ResourceLocation biomeAtPlayer = player.getCommandSenderWorld().getBiome(player.blockPosition()).getRegistryName();
            //LOGGER.info("Elden Land biome: >> {}", EldenBiomes.ELDEN_LAND.get());
            //LOGGER.info("Biome at player: >> {}", biomeAtPlayer);
           // if(biomeAtPlayer.equals(EldenBiomes.ELDEN_LAND.get().getRegistryName())) {
                // Enter elden land biome code
            //}

            //LOGGER.info(player.position());
        }

    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegistryEventsClient
    {
        @SubscribeEvent
        public static void clientSetupEvent(final FMLClientSetupEvent eventman)
        {
            //ItemBlockRenderTypes.setRenderLayer(EldenBlocks.LIMGRAVE_OAK_SAPLING.get(), RenderType.cutout());
        }
    }
}
