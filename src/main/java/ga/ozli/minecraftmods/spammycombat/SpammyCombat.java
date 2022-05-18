package ga.ozli.minecraftmods.spammycombat;

import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SpammyCombat.MOD_ID)
public class SpammyCombat {
    public static final String MOD_ID = "spammycombat";
    static final Logger LOGGER = LogManager.getLogger();

    public SpammyCombat() {
        LOGGER.info("SpammyCombat starting");
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
