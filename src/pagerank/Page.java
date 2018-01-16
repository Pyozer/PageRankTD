package pagerank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i161040 on 10/01/2018.
 */
public class Page {

    private double importance;
    private int id;
    private List<Page> pageIn = new ArrayList<>();
    private List<Page> pageOut = new ArrayList<>();

    public Page(double importance, int id) {
        this.importance = importance;
        this.id = id;
    }

    public Page(int id) {
        this.importance = 0.0f;
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

    public List<Page> getPageIn() {
        return pageIn;
    }

    public void setPageIn(List<Page> pageIn) {
        this.pageIn = pageIn;
    }

    public List<Page> getPageOut() {
        return pageOut;
    }

    public void setPageOut(List<Page> pageout) {
        this.pageOut = pageout;
    }

    public void addPageIn(Page... page) {
        this.pageIn.addAll(List.of(page));
    }

    public void addPageOut(Page... page) {
        this.pageOut.addAll(List.of(page));
    }

    @Override
    public String toString() {
        return "Page{importance=" + importance + ", id=" + id + "}";
    }
}
