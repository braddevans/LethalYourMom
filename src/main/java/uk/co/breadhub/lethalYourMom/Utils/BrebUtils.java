package uk.co.breadhub.lethalYourMom.Utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

import static net.kyori.adventure.text.format.TextColor.color;

public class BrebUtils {
    public static Component textComponent(String string_INPUT, int hex) {
        return Component.text().content(string_INPUT).color(color(hex)).build();
    }

    public static Component textComponent(String string_INPUT, NamedTextColor nt_color) {
        return Component.text().content(string_INPUT).color(nt_color).build();
    }

    public static Component textComponent(String string_INPUT) {
        return Component.text().content(string_INPUT).color(NamedTextColor.GOLD).build();
    }

}
