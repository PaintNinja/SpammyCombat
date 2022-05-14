package ga.ozli.minecraftmods.spammycombat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkConstants;
import org.slf4j.Logger;

@Mod(SpammyCombat.MOD_ID)
public class SpammyCombat {
    public static final String MOD_ID = "spammycombat";
    static final Logger LOGGER = LogUtils.getLogger();

    public SpammyCombat() {
        LOGGER.info("SpammyCombat starting");
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
    }
}
