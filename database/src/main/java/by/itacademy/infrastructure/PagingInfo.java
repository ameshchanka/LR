package by.itacademy.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagingInfo {

    private final int[] SELECT_ITEMSPERPAGE_DEFAULT = new int[] {1, 5, 10, 20, 50 , 100};
    private PagerModel pagerModel;
    private Long countItems;
    private Long itemsPerPage;
    private Long currentPage;
    private Long totalPage;

    public PagingInfo(Long countItems, Long itemsPerPage, Long currentPage) {
        this.countItems = countItems;
        this.itemsPerPage = checkNullAndZero(itemsPerPage)
                ? (long)SELECT_ITEMSPERPAGE_DEFAULT[2] : itemsPerPage;
        this.currentPage = checkNullAndZero(currentPage)
                ? 1L : ((this.countItems / this.itemsPerPage < currentPage)
                    ? 1L : currentPage);
        this.totalPage = this.countItems % this.itemsPerPage == 0
                ? (this.countItems / this.itemsPerPage) : (this.countItems / this.itemsPerPage + 1);
        this.pagerModel = new PagerModel(this.itemsPerPage, this.currentPage, this.countItems);
    }

    private boolean checkNullAndZero(Long number) {
        return number == null || number == 0L;
    }
}
