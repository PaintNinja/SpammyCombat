package ga.ozli.minecraftmods.spammycombat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = SpammyCombat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
final class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> BLACKLIST_STRINGS = BUILDER
            .comment("A list of items that spam-clicking combat doesn't apply to. Note that sword sweep attacks are still disabled.")
            .defineListAllowEmpty(Collections.singletonList("blacklist"), Collections::emptyList, Config::validateItemName);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    private static boolean USE_BLACKLIST;
    private static Set<Item> BLACKLIST;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(itemName));
    }

    static boolean canSpamClickWith(final ItemStack itemStack) {
        return !USE_BLACKLIST || !BLACKLIST.contains(itemStack.getItem());
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        USE_BLACKLIST = !BLACKLIST_STRINGS.get().isEmpty();

        BLACKLIST = USE_BLACKLIST
                ? BLACKLIST_STRINGS.get().stream()
                        .map(itemName -> ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName)))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toUnmodifiableSet())
                : Collections.emptySet();
    }
}
