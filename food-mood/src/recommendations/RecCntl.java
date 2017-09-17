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
        System.out.println("Rec Controller constructor");

        this.rec = rec;
        this.recView = recView;
    }

    /**
     * @return the rec
     */
    public RecModel getRec() {
        return rec;
    }

    /**
     * @param rec the rec to set
     */
    public void setRec(RecModel rec) {
        this.rec = rec;
    }

    /**
     * @return the recView
     */
    public RecView getRecView() {
        return recView;
    }

    /**
     * @param recView the recView to set
     */
    public void setMoodView(RecView recView) {
        this.recView = recView;
    }
}
