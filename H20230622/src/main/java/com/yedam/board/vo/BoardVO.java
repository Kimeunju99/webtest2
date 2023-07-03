package com.yedam.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long brdNo;
	private String brdTitle;
	private String brdWriter;
	private String brdContent;
	private Date createdate;
	private int clickCnt;
	
}
