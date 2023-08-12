package com.hic.exam.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	public int id;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;
}
