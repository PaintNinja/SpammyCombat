package ga.ozli.minecraftmods.spammycombat;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    @SubscribeEvent
    public static void onEntityUpdate(final LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof final Player player && Config.canSpamClickWith(player.getMainHandItem()))
            player.attackStrengthTicker = 20;
    }

}
