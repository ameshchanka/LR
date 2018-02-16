package by.itacademy.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagingInfo {

    private PagerModel pagerModel;
    private Long totalItems;
    private Long itemsPerPage;
    private int currentPage = 1;
    private Long totalPage;

    public PagingInfo(Long totalItems, Long itemsPerPage, int currentPage) {
        this.totalItems = totalItems;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = currentPage;
        this.totalPage = totalItems % itemsPerPage == 0
                ? (totalItems / itemsPerPage)
                : (totalItems / itemsPerPage + 1);
        this.pagerModel = new PagerModel(itemsPerPage, currentPage, totalItems);
    }
}
