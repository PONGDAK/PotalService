package com.portal.service.service.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pager {
    public static final int PAGE_SCALE = 10;
    public static final int BLOCK_SCALE = 10;

    private int totalPage;
    private int currentPage;
    private int previousPage;
    private int nextPage;
    private int totalBlock;
    private int currentBlock;
    private int beginPage;
    private int endPage;
    private int beginBlock;
    private int endBlock;

    public Pager(int count, int currentPage) {
        currentBlock = 1; //현재블록 번호
        this.currentPage = currentPage; //현재 페이지 번호
        setTotalPage(count);
        setPageRange();
        setTotalBlock();
        setBlockRange();
    }

    public void setBlockRange() {

        //원하는 페이지가 몇번째 블록에 속하는지 계산
        currentBlock = (currentPage - 1) / BLOCK_SCALE + 1;
        //블록의 시작페이지,끝페이지 번호 계산
        beginBlock = (currentBlock - 1) * BLOCK_SCALE + 1;
        endBlock = beginBlock + BLOCK_SCALE - 1;
        //마지막 블록 번호가 범위를 초과하지 않도록 처리
        if (endBlock > totalPage) {
            endBlock = totalPage;
        }
        //[이전][다음]을 눌렀을 때 이동할 페이지 번호
        previousPage = (currentBlock == 1) ? 1 : (currentBlock - 1) * BLOCK_SCALE;
        nextPage = currentBlock > totalBlock ? (currentBlock * BLOCK_SCALE)
                : (currentBlock * BLOCK_SCALE) + 1;
        //마지막 페이지가 범위를 초과하지 않도록 처리
        if (nextPage >= totalPage) {
            nextPage = totalPage;
        }
    }

    public void setTotalBlock() {
        totalBlock = (int) Math.ceil(totalPage * 1.0 / BLOCK_SCALE);
    }

    public void setPageRange() {
        beginPage = (currentPage - 1) * PAGE_SCALE;
        endPage = beginPage + PAGE_SCALE;
    }

    public void setTotalPage(int count) {
        totalPage = (int) Math.ceil(count * 1.0 / PAGE_SCALE);
    }
}
