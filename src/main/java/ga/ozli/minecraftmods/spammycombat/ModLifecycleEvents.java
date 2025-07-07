package ga.ozli.minecraftmods.spammycombat;

import net.minecraftforge.common.ToolActions;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraftforge.common.ToolActions.SWORD_SWEEP;

@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModLifecycleEvents {

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> ToolActions.DEFAULT_SWORD_ACTIONS.remove(SWORD_SWEEP));
    }

}
