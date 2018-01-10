package pagerank;

/**
 * Created by i161040 on 10/01/2018.
 */
public class Page {
    float importance;
    int id;

    public Page(float importance, int id) {
        this.importance = importance;
        this.id = id;
    }

    public Page(int id) {
        this.importance=0.0f;
        this.id = id;
    }

    public float getImportance() {
        return importance;
    }

    public void setImportance(float importance) {
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
