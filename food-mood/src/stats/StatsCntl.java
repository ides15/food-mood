package stats;
/*
 * @author BasicPanda
 */
public class StatsCntl {
    private StatsModel stats;
    private StatsView statsView;
    
    /**
     * Default constructor for MoodCntl.
     * @param stats Mood model for MVC architecture.
     * @param statsView MoodView for MVC architecture.
     */
    public StatsCntl(StatsModel stats, StatsView statsView) {
        System.out.println("StatsCntl constructor called.");
        
        this.stats = stats;
        this.statsView = statsView;
    }

    /**
     * @return the stats
     */
    public StatsModel getStats() {
        System.out.println("getStats called.");
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(StatsModel stats) {
        System.out.println("setStats called.");
        this.stats = stats;
    }

    /**
     * @return the statsView
     */
    public StatsView getStatsView() {
        System.out.println("getStatsView called.");
        return statsView;
    }

    /**
     * @param statsView the statsView to set
     */
    public void setMoodView(StatsView statsView) {
        System.out.println("setMoodView called.");
        this.statsView = statsView;
    }
}
