package uk.co.breadhub.lethalYourMom;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.breadhub.lethalYourMom.Listeners.YoMothersMinecartListener;

public final class AmongUs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("Lethal Your Mom Enabled");

        // register listeners
        getServer().getPluginManager().registerEvents(new YoMothersMinecartListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
