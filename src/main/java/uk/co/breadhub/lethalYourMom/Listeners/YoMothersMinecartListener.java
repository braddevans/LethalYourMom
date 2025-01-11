package uk.co.breadhub.lethalYourMom.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import uk.co.breadhub.lethalYourMom.AmongUs;
import uk.co.breadhub.lethalYourMom.Utils.BrebUtils;
import uk.co.breadhub.lethalYourMom.Utils.CooldownManager;

import java.time.Duration;

public class YoMothersMinecartListener implements Listener {

    private final AmongUs plugin;
    private final CooldownManager cooldownManager = new CooldownManager();

    public YoMothersMinecartListener(AmongUs plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        Entity entity = event.getEntity();
        Vehicle vehicle = event.getVehicle();
        String entityUUID = entity.getUniqueId().toString();

        Duration timeLeft = cooldownManager.getRemainingCooldown(entityUUID);
        if (timeLeft.isZero() || timeLeft.isNegative()) {
            if (vehicle instanceof Minecart && vehicle.getVelocity().length() >= 0.2) {
                plugin.getLogger().info("[+] Minecart: " + entityUUID);
                String location = "World: " + vehicle.getLocation().getWorld().getName() + ", X: " + (int) vehicle.getLocation().getX() + ", Y: " + (int) vehicle.getLocation().getY() + ", Z: " + (int) vehicle.getLocation().getZ();
                plugin.getServer().broadcast(BrebUtils.textComponent("[+] Minecart Hit Entity: " + entity.getName() + " At Position: " + location, 0x13f832));
                LivingEntity entityHit = (LivingEntity) plugin.getServer().getEntity(entity.getUniqueId());
                assert entityHit != null;
                if (vehicle.getVelocity().length() >= 1) {
                    // who needed their kneecaps anyway
                    entityHit.damage(100);
                } else {
                    entityHit.damage(10);
                }
            }
            cooldownManager.setCooldown(entityUUID, Duration.ofSeconds(CooldownManager.DEFAULT_COOLDOWN));
        }


    }
}
