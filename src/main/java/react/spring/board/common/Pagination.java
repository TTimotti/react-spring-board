package react.spring.board.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
* 테스트 해보지 않은 코드라 
* 문제가 있을 수 있어서
* 향후 수정을 해야 할 수도 있음
* 안되면 일단 남이 만들어 둔 페이징 코드 쓸 것
* TODO
*  */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private int currentPage; // 현재 페이지
    private int totalItems; // 전체 아이템 수
    private int totalPages; // 전체 페이지 수
    private int totalBlocks; // 전체 블럭 수
    private int startPage; // 블록 별 시작 페이지
    private int startBlock; // 범위 별 시작 블록    
    private int itemsPerPage = 10;  // 페이지 별 아이템 수
    private int pagesPerBlock = 10; // 블록 별 페이지 수 (범위)
    private int offset;
    private int limit;
    
    private boolean hasPrevPage; // 이전 페이지 여부
    private boolean hasNextPage; // 다음 페이지 여부
    private boolean hasPrevBlock; // 이전 블록 여부
    private boolean hasNextBlock; // 다음 블록 여부

    private String key;
    private String value;

    public void paging(int totalItems) {
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / itemsPerPage); // 전체 페이지 수
        this.totalBlocks = (int) Math.ceil((double) totalPages / pagesPerBlock); // 전체 블록 수
        this.startPage = (currentPage - 1) * pagesPerBlock + 1; // 현재 페이지에 해당하는 블록의 시작 페이지
        this.startBlock = (int) Math.ceil((double) currentPage / pagesPerBlock) * pagesPerBlock - pagesPerBlock + 1; // 현재 블록의 시작 블록
        this.hasPrevPage = currentPage > 1; // 이전 페이지 여부
        this.hasNextPage = currentPage < totalPages; // 다음 페이지 여부
        this.hasPrevBlock = startBlock > 1; // 이전 블록 여부
        this.hasNextBlock = startBlock + pagesPerBlock <= totalBlocks * pagesPerBlock; // 다음 블록 여부
        this.offset = (currentPage - 1) * itemsPerPage; // offset 설정
        this.limit = itemsPerPage; // limit 설정
    }
}