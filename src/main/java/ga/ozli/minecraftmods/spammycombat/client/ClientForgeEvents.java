//package ga.ozli.minecraftmods.spammycombat.client;
//
//import ga.ozli.minecraftmods.spammycombat.SpammyCombat;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.components.AbstractWidget;
//import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
//import net.minecraft.network.chat.Component;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.client.event.ScreenEvent;
//import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import org.jetbrains.annotations.Nullable;
//
//// todo: fix
////@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//public class ClientForgeEvents {
//
//    @Nullable
//    private static AbstractWidget OPTION = null;
//
//    /**
//     * Disable the attack indicator option in the video settings screen so that it can't be clicked.
//     */
//    @SubscribeEvent
//    public static void onPostScreenInit(final ScreenEvent.Init.Post event) {
//        if (event.getScreen() instanceof final VideoSettingsScreen screen) {
////            @Nullable
////            final AbstractWidget option = OptifineWorkarounds.IS_OPTIFINE_INSTALLED
////                    ? OptifineWorkarounds.getAttackIndicatorButton(screen)
////                    : screen.list.findOption(screen.options.attackIndicator());
//
////            if (option != null) {
////                OPTION = option;
////                OPTION.active = false;
////            }
//        }
//    }
//
//    /**
//     * Show a custom tooltip for the attack indicator option in the video settings screen.
//     * Vanilla doesn't render tooltips for disabled buttons, so let's manually do it.
//     */
//    @SubscribeEvent
//    public static void onPostScreenDraw(final ScreenEvent.Render.Post event) {
//        if (event.getScreen() instanceof final VideoSettingsScreen screen) {
//            if (OPTION != null) {
//                final int mouseX = event.getMouseX();
//                final int mouseY = event.getMouseY();
//                if (isMouseOver(OPTION, mouseX, mouseY)) {
//                    final var tooltip = Minecraft.getInstance().font
//                            .split(Component.translatable("spammycombat.options.attackIndicator.tooltip"), 200);
//                    screen.setTooltipForNextRenderPass(tooltip);
//                }
//            }
//        }
//    }
//
//    private static boolean isMouseOver(final AbstractWidget widget, final double pMouseX, final double pMouseY) {
//        return widget.visible && pMouseX >= (double)widget.x && pMouseY >= (double)widget.y
//                && pMouseX < (double)(widget.x + widget.getWidth()) && pMouseY < (double)(widget.y + widget.getHeight());
//    }
//}
