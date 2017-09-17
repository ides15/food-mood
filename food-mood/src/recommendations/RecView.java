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
    public RecView(RecModel Rec) {
        System.out.println("Rec View constructor");
        this.rec = rec;
    }

    /**
     * @return the rec
     */
    public RecModel getRec() {
        return rec;
    }
}