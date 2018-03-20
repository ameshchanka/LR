package by.itacademy.infrastructure;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PagerModel {

    private final int settingNumber4 = 4;
    private final int settingNumber6 = 6;
    private final int settingNumber9 = 9;

    private List<PagerLinks> pagerLinks;
    
    public PagerModel(Long pageSize, long currentPage, long totalItem) {
        int pageCount = (int) (Math.ceil((double) totalItem / pageSize));
        pagerLinks = new ArrayList<PagerLinks>();
        if (pageCount > 1) {
            int firstPageNumber = 1;
            if (pageCount > settingNumber9) {
                pagerLinks.add(new PagerLinks("<", currentPage - 1));
                pagerLinks.add(new PagerLinks(Integer.toString(firstPageNumber), firstPageNumber));
                if ((firstPageNumber + settingNumber4) >= currentPage) {
                    for (int i = firstPageNumber + 1; i <= firstPageNumber + settingNumber6; i++) {
                        pagerLinks.add(new PagerLinks(Integer.toString(i), i));
                    }
                    pagerLinks.add(new PagerLinks("..", -1));
                } else if ((pageCount - settingNumber4) <= currentPage) {
                    pagerLinks.add(new PagerLinks("..", -1));
                    for (int i = pageCount - settingNumber6; i <= pageCount - 1; i++) {
                        pagerLinks.add(new PagerLinks(Integer.toString(i), i));
                    }
                } else {
                    pagerLinks.add(new PagerLinks("..", -1));
                    for (long i = currentPage - 2; i <= currentPage + 2; i++) {
                        pagerLinks.add(new PagerLinks(Long.toString(i), i));
                    }
                    pagerLinks.add(new PagerLinks("..", -1));
                }
                pagerLinks.add(new PagerLinks(Integer.toString(pageCount), pageCount));
                if (currentPage < pageCount) {
                    pagerLinks.add(new PagerLinks(">", currentPage + 1));
                } else {
                    pagerLinks.add(new PagerLinks(">", 0));
                }
            } else {
                pagerLinks.add(new PagerLinks("<", currentPage - 1));
                for (int i = firstPageNumber; i <= pageCount; i++) {
                    pagerLinks.add(new PagerLinks(Integer.toString(i), i));
                }
                if (currentPage < pageCount) {
                    pagerLinks.add(new PagerLinks(">", currentPage + 1));
                } else {
                    pagerLinks.add(new PagerLinks(">", 0));
                }
            }
        }
    }
}
