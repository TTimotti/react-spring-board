package study.work.signAccess.model.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private int pageSize;
    private int blockSize = 10; // default:10
    private int currentPage;
    private int currentBlock;
    private int prevBlock;
    private int nextBlock;
    private int totalItems;
    private int totalPages;
    private int totalBlocks;
    private String key;
    private String value;

    public Pagination(int currentPage, int pageSize, int totalItems) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
        this.totalBlocks = (int) Math.ceil((double) totalPages / blockSize);
    }

    public int getStartIndex() {
        return (currentPage - 1) * pageSize;
    }

    public int getEndIndex() {
        return Math.min(currentPage * pageSize, totalItems);
    }

    public boolean hasPrevBlock() {
        return currentBlock > 1;
    }

    public boolean hasNextBlock() {
        return currentBlock < totalBlocks;
    }

    public int getPrevBlock() {
        return currentBlock - 1;
    }

    public int getNextBlock() {
        return currentBlock + 1;
    }
}
