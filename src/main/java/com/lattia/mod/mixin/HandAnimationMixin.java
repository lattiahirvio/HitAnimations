package com.lattia.mod.mixin;

import com.lattia.mod.HandAnimation;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import static com.lattia.mod.helpers.LattiaMC.mc;

@Mixin(MinecraftClient.class)
public class HandAnimationMixin {
    @Inject(at=@At("HEAD"), method=("tick"), cancellable = true)
    public void ApplySwingOffset() {
        if (mc.player != null) {
            if (mc.player.handSwingProgress > 0 && HandAnimation.isToggled)
                mc.player.handSwinging = false;
        }
    }
}