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
        System.out.println("statsView constructor called.");
        this.stat = stat;
    }

    /**
     * @return the stats
     */
    public StatsModel getStats() {
        System.out.println("getStats called.");
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(StatsModel stat) {
        System.out.println("setStat called.");
        this.stat = stat;
    }
}
