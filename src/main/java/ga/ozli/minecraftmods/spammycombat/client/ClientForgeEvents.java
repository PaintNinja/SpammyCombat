package ga.ozli.minecraftmods.spammycombat.client;

import ga.ozli.minecraftmods.spammycombat.SpammyCombat;
import net.minecraft.client.AbstractOption;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.VideoSettingsScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEvents {

    @Nullable
    private static Widget OPTION = null;

    /**
     * Disable the attack indicator option in the video settings screen so that it can't be clicked.
     */
    @SubscribeEvent
    public static void onPostScreenInit(final GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.getGui() instanceof VideoSettingsScreen) {
            final VideoSettingsScreen screen = (VideoSettingsScreen) event.getGui();

            @Nullable
            final Widget option = screen.list.findOption(AbstractOption.ATTACK_INDICATOR);

            if (option != null) {
                OPTION = option;
                OPTION.active = false;
            }
        }
    }

    /**
     * Show a custom tooltip for the attack indicator option in the video settings screen.
     * Vanilla doesn't render tooltips for disabled buttons, so let's manually do it.
     */
    @SubscribeEvent
    public static void onPostScreenDraw(final GuiScreenEvent.DrawScreenEvent.Post event) {
        if (event.getGui() instanceof VideoSettingsScreen) {
            final VideoSettingsScreen screen = (VideoSettingsScreen) event.getGui();

            if (OPTION != null) {
                final int mouseX = event.getMouseX();
                final int mouseY = event.getMouseY();
                if (isMouseOver(OPTION, mouseX, mouseY)) {
                    final List<IReorderingProcessor> tooltip = Minecraft.getInstance().font
                            .split(new TranslationTextComponent("spammycombat.options.attackIndicator.tooltip"), 200);
                    screen.renderTooltip(event.getMatrixStack(), tooltip, mouseX, mouseY);
                }
            }

        }
    }

    private static boolean isMouseOver(final Widget widget, final double pMouseX, final double pMouseY) {
        return widget.visible && pMouseX >= (double)widget.x && pMouseY >= (double)widget.y
                && pMouseX < (double)(widget.x + widget.getWidth()) && pMouseY < (double)(widget.y + widget.getHeight());
    }
}
