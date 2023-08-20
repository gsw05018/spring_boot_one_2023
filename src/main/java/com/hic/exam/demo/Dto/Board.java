package com.hic.exam.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int id;
	private String regDate;
	private String  updateDate;
	private String code;
	private String name;
	private boolean blindStatus;
	private String blindDate;
	private int hitConunt;
	private int repliesCount;
	private int likeCount;
	private int dislikeCount;
	
	
}
