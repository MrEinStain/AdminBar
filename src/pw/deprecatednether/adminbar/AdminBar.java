/*
 * AdminBar is a Bukkit plugin that displays server information to administrators at all times.
 * Copyright (C) 2014 DeprecatedNether
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package pw.deprecatednether.adminbar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class AdminBar extends JavaPlugin {

    public static Scoreboard sb;

    public void onEnable() {
        ScoreboardManager sbm = Bukkit.getServer().getScoreboardManager();
        sb = sbm.getNewScoreboard();
        Objective tps = sb.registerNewObjective("tps", "dummy");
        Objective players = sb.registerNewObjective("players", "dummy");
        tps.setDisplayName("Server TPS");
        players.setDisplayName("Online players");
        this.getServer().getPluginManager().registerEvents(new AdminListener(), this);
    }

    public void onDisable() {

    }

    /**
     * Get the current TPS.
     * @return The ticks per second rate, rounded to two decimals.
     */
    public static double getTPS() { // TODO
        return -1;
    }

    /**
     * Get online players
     * @return The number of online players.
     */
    public static int getOnline() {
        return Bukkit.getServer().getOnlinePlayers().length;
    }
}
