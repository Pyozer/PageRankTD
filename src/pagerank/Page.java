package pagerank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i161040 on 10/01/2018.
 */
public class Page {

    private double importance;
    private int id;
    private List<Page> pagesIn = new ArrayList<>();
    private List<Page> pagesOut = new ArrayList<>();

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

    public List<Page> getPagesIn() {
        return pagesIn;
    }

    public void setPagesIn(Page... pagesIn) {
        setPagesIn(List.of(pagesIn));
    }

    public void setPagesIn(List<Page> pagesIn) {
        this.pagesIn = pagesIn;
    }

    public List<Page> getPagesOut() {
        return pagesOut;
    }

    public void setPagesOut(Page... pagesOut) {
        setPagesIn(List.of(pagesOut));
    }

    public void setPagesOut(List<Page> pagesOut) {
        this.pagesOut = pagesOut;
        for (Page pageDest : pagesOut) {
            pageDest.addPageIn(this);
        }
    }

    private void addPageIn(Page... pages) {
        this.pagesIn.addAll(List.of(pages));
    }

    public void addPagesOut(Page... pages) {
        this.pagesOut.addAll(List.of(pages));
    }

    @Override
    public String toString() {
        return "Page{importance=" + importance + ", id=" + id + "}";
    }
}
