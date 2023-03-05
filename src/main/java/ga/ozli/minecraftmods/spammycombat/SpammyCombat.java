package ga.ozli.minecraftmods.spammycombat;

import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fmllegacy.network.FMLNetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SpammyCombat.MOD_ID)
public class SpammyCombat {
    public static final String MOD_ID = "spammycombat";
    static final Logger LOGGER = LogManager.getLogger();

    public SpammyCombat() {
        LOGGER.info("SpammyCombat starting");
        final var modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modLoadingContext.registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
