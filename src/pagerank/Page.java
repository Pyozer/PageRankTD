package pagerank;

/**
 * Created by i161040 on 10/01/2018.
 */
public class Page {
    double importance;
    int id;

    public Page(double importance, int id) {
        this.importance = importance;
        this.id = id;
    }

    public Page(int id) {
        this.importance=0.0f;
        this.id = id;
    }

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Page{importance=" + importance + ", id=" + id +"}";
    }
}
