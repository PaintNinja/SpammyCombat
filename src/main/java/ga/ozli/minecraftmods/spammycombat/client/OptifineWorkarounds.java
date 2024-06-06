package ga.ozli.minecraftmods.spammycombat.client;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.VideoSettingsScreen;

import java.lang.reflect.Method;
import java.util.List;

final class OptifineWorkarounds {
    private OptifineWorkarounds() {}

    static final boolean IS_OPTIFINE_INSTALLED;
    
    static {
        boolean tmp;
        try {
            Class.forName("net.optifine.Config");
            tmp = true;
        } catch (final ClassNotFoundException e) {
            tmp = false;
        }
        IS_OPTIFINE_INSTALLED = tmp;
    }

    static AbstractWidget getAttackIndicatorButton(final VideoSettingsScreen screen) {
        try {
            final Method m = screen.getClass().getSuperclass().getDeclaredMethod("getButtonList");
            final List<AbstractWidget> optifineButtonList = (List<AbstractWidget>) m.invoke(screen);
//            for (int i = 0; i < optifineButtonList.size(); i++) {
//                SpammyCombat.LOGGER.info(i + ": " + optifineButtonList.get(i).getMessage().getString());
//            }
            return optifineButtonList.get(9);
        } catch (final Exception e) {
            return null;
        }
    }
}
