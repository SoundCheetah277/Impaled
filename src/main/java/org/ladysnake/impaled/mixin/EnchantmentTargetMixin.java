package org.ladysnake.impaled.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.ItemStack;
import org.ladysnake.impaled.common.item.AtlanItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentTargetMixin {
    @Shadow
    @Final
    public EnchantmentEffectTarget target;

    @Inject(method = "isAcceptableItem", at = @At(value = "RETURN"), cancellable = true)
    public void isAcceptableItem(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue() && itemStack.getItem() instanceof AtlanItem && this.target == EnchantmentEffectTarget.ATTACKER) {
            cir.setReturnValue(true);
        }
    }
}
