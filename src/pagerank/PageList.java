package pagerank;

import java.util.ArrayList;
import java.util.List;

public class PageList extends ArrayList<Page> {

    public PageList(Page... pages) {
        super();
        addAll(List.of(pages));
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