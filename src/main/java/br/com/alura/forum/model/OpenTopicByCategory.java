package br.com.alura.forum.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OpenTopicByCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	private int topicCount;
	private LocalDate date = LocalDate.now();

	@Deprecated
	public OpenTopicByCategory() {
	}

	public OpenTopicByCategory(String categoryName, Number topicCount) {
		this.categoryName = categoryName;
		this.topicCount = topicCount.intValue();
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public LocalDate getDate() {
		return date;
	}
	
}
