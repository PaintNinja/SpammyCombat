package ga.ozli.minecraftmods.spammycombat.client;

import ga.ozli.minecraftmods.spammycombat.SpammyCombat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.AttackIndicatorStatus;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModLifecycleEvents {

    /**
     * Turn off the attack indicator.
     */
    @SubscribeEvent
    public static void onLoadComplete(final FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            Minecraft mc = Minecraft.getInstance();
            mc.options.attackIndicator = AttackIndicatorStatus.OFF;
            mc.options.save();
        });
    }

}