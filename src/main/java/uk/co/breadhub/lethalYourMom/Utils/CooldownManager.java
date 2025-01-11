package uk.co.breadhub.lethalYourMom.Utils;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class CooldownManager {
    public static Long DEFAULT_COOLDOWN = 5L;
    private final Map<String, Instant> map = new HashMap<>();

    // Set cooldown
    public void setCooldown(String key, Duration duration) {
        map.put(key, Instant.now().plus(duration));
    }

    // Check if cooldown has expired
    public boolean hasCooldown(String key) {
        Instant cooldown = map.get(key);
        return cooldown != null && Instant.now().isBefore(cooldown);
    }

    // Remove cooldown
    public Instant removeCooldown(String key) {
        return map.remove(key);
    }

    // Get remaining cooldown time
    public Duration getRemainingCooldown(String key) {
        Instant cooldown = map.get(key);
        Instant now = Instant.now();
        if (cooldown != null && now.isBefore(cooldown)) {
            return Duration.between(now, cooldown);
        } else {
            return Duration.ZERO;
        }
    }
}
 