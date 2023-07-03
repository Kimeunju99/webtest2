package com.yedam.common;

import lombok.Data;

//전체 전수를 기준으로 페이지 계산
@Data
public class PageDTO {
	private int curPage, total, startPage, endPage; //현재 페이지가 속한 처음과 끝(ex. 1=> 1~10 || 13 => 11~20)
	private boolean prev, next;
	
	public PageDTO(int curPage, int total) {
		this.curPage = curPage;
		this.total = total;
		
		this.endPage = (int) Math.ceil((double)curPage/10)*10;
		this.startPage = this.endPage - 9;
		
		int realEnd = (int)(Math.ceil((double)total/10));
		if(realEnd <this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1 ;
		this.next = this.endPage < realEnd;
	}

	@Override
	public String toString() {
		return "PageDTO [curPage=" + curPage + ", total=" + total + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
