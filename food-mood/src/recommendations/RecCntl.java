package recommendations;

/*
 * @author BasicPanda
 */
public class RecCntl {

    private RecModel rec;
    private RecView recView;

    /**
     * Default constructor for RecCntl.
     *
     * @param rec Mood model for MVC architecture.
     * @param recView MoodView for MVC architecture.
     */
    public RecCntl(RecModel rec, RecView recView) {
        System.out.println("RecCntl constructor called.");

        this.rec = rec;
        this.recView = recView;
    }

    /**
     * @return the rec
     */
    public RecModel getRec() {
        System.out.println("getRec called.");
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(RecModel rec) {
        System.out.println("setRec called.");
        this.rec = rec;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        System.out.println("getRecView called.");
        return recView;
    }

    /**
     * @param recView the recView to set
     */
    public void setRecView(RecView recView) {
        System.out.println("setRecView called.");
        this.recView = recView;
    }
}
