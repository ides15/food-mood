package recommendations;
/*
 * @author BasicPanda
 */
public class RecView {
    private RecModel rec;
    
    /**
     * Default constructor for rec view
     * @param rec accepts Rec model as parameter
     */
    public RecView(RecModel rec) {
        System.out.println("RecView constructor called.");
        this.rec = rec;
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
}