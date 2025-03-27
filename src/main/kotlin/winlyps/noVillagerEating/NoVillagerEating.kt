package winlyps.noVillagerEating

import org.bukkit.plugin.java.JavaPlugin

class NoVillagerEating : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(VillagerFoodListener(this), this)
        logger.info("NoVillagerEating has been enabled")
    }

    override fun onDisable() {
        logger.info("NoVillagerEating has been disabled")
    }
}