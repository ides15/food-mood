package stats;
/*
 * @author BasicPanda
 */

public class StatsView {
    private StatsModel stat;
    
    /**
     * Default constructor for stat view
     * @param stat accepts Stat model as parameter
     */
    public StatsView(StatsModel stat) {
        System.out.println("Mood View constructor");
        this.stat = stat;
    }

    /**
     * @return the stats
     */
    public StatsModel getStats() {
        return stat;
    }

}
