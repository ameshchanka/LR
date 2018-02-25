package by.itacademy.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagingInfo {

    private final int[] itemsPerPageArray = new int[] {1, 5 , 10 , 50};
    private PagerModel pagerModel;
    private Long totalItems;
    private Long itemsPerPage;
    private long currentPage = 1;
    private Long totalPage;

    public PagingInfo(Long totalItems, Long itemsPerPage, long currentPage) {
        this.totalItems = totalItems;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = currentPage;
        this.totalPage = totalItems % itemsPerPage == 0
                ? (totalItems / itemsPerPage)
                : (totalItems / itemsPerPage + 1);
        this.pagerModel = new PagerModel(itemsPerPage, currentPage, totalItems);
    }
}
