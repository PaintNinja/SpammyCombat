package ga.ozli.minecraftmods.spammycombat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(SpammyCombat.MOD_ID)
public final class SpammyCombat {
    public static final String MOD_ID = "spammycombat";
    static final Logger LOGGER = LogUtils.getLogger();

    public SpammyCombat(FMLJavaModLoadingContext context) {
        LOGGER.info("SpammyCombat starting");
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
