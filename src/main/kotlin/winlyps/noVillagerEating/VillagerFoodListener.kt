package winlyps.noVillagerEating

import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent

class VillagerFoodListener(private val plugin: NoVillagerEating) : Listener {

    private val foodItems = setOf(
            Material.BREAD,
            Material.CARROT,
            Material.POTATO,
            Material.BEETROOT
    )

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    fun onVillagerPickupItem(event: EntityPickupItemEvent) {
        if (event.entityType != EntityType.VILLAGER) {
            return
        }

        val item = event.item.itemStack.type

        if (foodItems.contains(item)) {
            event.isCancelled = true
            plugin.logger.fine("Prevented villager from picking up food item: ${item.name}")
        }
    }
}