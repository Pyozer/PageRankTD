package pagerank;

import java.util.ArrayList;
import java.util.List;

public class PageList extends ArrayList<Page> {

    public PageList(Page... pages) {
        super();
        addAll(List.of(pages));
    }

    public void addAll(Page... pages) {
        addAll(List.of(pages));
    }

    public double getWeight() {
        double weight = 0.0f;
        for(Page page: this) {
            weight += 1.0f / (double) page.getPagesOut().size();
        }
        return weight;
    }

    /**
     * Renvoi l'ID maximum sur l'ensembe des pages
     *
     * @return Id maximum (int)
     */
    public int getMaxId() {
        if (size() == 0)
            return 0;

        int max = get(0).getId();
        if (size() == 1)
            return max;

        for (int i = 1; i < size(); i++) {
            Page page = get(i);
            if (page.getId() > max)
                max = page.getId();
        }
        return max;
    }
}