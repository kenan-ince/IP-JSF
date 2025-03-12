package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import java.io.Serializable;

@Entity
public class Post implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Category category;
	private String title;
	
	@Lob
	private String context;

	public Post() {
	}

	public Post(Long id, Category category, String title, String context) {
		this.id = id;
		this.category = category;
		this.title = title;
		this.context = context;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "Post{" + "id=" + id + ", category=" + category + ", title=" + title + ", context=" + context + '}';
	}
	
	
}
