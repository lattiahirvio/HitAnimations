
package com.lattia.mod.mixin;

import com.lattia.mod.HandAnimation;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({OptionsScreen.class})
public abstract class OptionsScreenMixin extends Screen {
    private OptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = {@At("HEAD")}, method = {"init()V"})
    private void init(CallbackInfo info) {
        addDrawableChild(ButtonWidget.builder(this.width / 2 - 180 - 50, this.height / 6 + 120 - 6, 60, 20, Text.translatable("animation.button"), (button) -> {
            HandAnimation.isToggled = !HandAnimation.isToggled;
        }));
    }
}
