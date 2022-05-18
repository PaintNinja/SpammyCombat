package ga.ozli.minecraftmods.spammycombat.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public class SwordSweepDisablerMixin {

    /**
     * Modify the setter to the first variable with type ItemStack inside the PlayerEntity.attack() method to
     * ItemStack.EMPTY to prevent the sword from doing a sweep attack.
     *
     * This is required due to MinecraftForge#7970 and #7981 only being in 1.17+ and not able to be backported to
     * 1.16 due to the breaking changes it would cause.
     */
    @ModifyVariable(
            method = "Lnet/minecraft/entity/player/PlayerEntity;attack(Lnet/minecraft/entity/Entity;)V",
            at = @At("STORE"),
            ordinal = 0
    )
    private ItemStack mixin(ItemStack oldValue) {
        return ItemStack.EMPTY;
    }
}
