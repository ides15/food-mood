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
        System.out.println("Mood Controller constructor");
        
        this.stats = stats;
        this.statsView = statsView;
    }

    /**
     * @return the stats
     */
    public StatsModel getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(StatsModel stats) {
        this.stats = stats;
    }

    /**
     * @return the statsView
     */
    public StatsView getStatsView() {
        return statsView;
    }

    /**
     * @param statsView the statsView to set
     */
    public void setMoodView(StatsView statsView) {
        this.statsView = statsView;
    }
}
