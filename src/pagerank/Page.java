package pagerank;

/**
 * Created by i161040 on 10/01/2018.
 */
public class Page {

    private double importance;
    private int id;
    private PageList pagesIn = new PageList();
    private PageList pagesOut = new PageList();

    public Page(double importance, int id) {
        this.importance = importance;
        this.id = id;
    }

    public Page(int id) {
        this(0.0f, id);
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

    public PageList getPagesIn() {
        return pagesIn;
    }

    public PageList getPagesOut() {
        return pagesOut;
    }

    public void setPagesOut(Page... pagesOut) {
        setPagesOut(new PageList(pagesOut));
    }

    public void setPagesOut(PageList pagesOut) {
        this.pagesOut = pagesOut;
        for (Page pageDest : pagesOut) {
            pageDest.addPageIn(this);
        }
    }

    private void addPageIn(Page... pages) {
        this.pagesIn.addAll(pages);
    }

    public void addPagesOut(Page... pages) {
        this.pagesOut.addAll(pages);
    }

    @Override
    public String toString() {
        return "Page{importance=" + importance + ", id=" + id + "}";
    }
}
