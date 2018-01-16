package pagerank;

/**
 * Created by Leo on 10/01/2018.
 */
public class PageComparator implements java.util.Comparator<Page> {

    @Override
    public int compare(Page p1, Page p2) {
        return Double.compare(p1.getImportance(), p2.getImportance());
    }
}