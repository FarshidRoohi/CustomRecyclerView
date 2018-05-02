package farshid_roohi.ir.sample.customrecyclerview.sample;


public class ModelSample {

    private int id;
    private String name;
    private String family;

    public ModelSample(int id , String name , String family){
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
