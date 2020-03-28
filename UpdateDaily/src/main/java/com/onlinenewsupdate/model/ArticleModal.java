package com.onlinenewsupdate.model;

public class ArticleModal {
	private Object author;
	private String title;
	private String description;
	private Object url;
	private Object urlToImage;
	private String publishedAt;
	private String content;


	public Object getAuthor() {
		return author;
	}


	public void setAuthor(Object author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Object getUrl() {
		return url;
	}


	public void setUrl(Object url) {
		this.url = url;
	}


	


	public Object getUrlToImage() {
		return urlToImage;
	}


	public void setUrlToImage(Object urlToImage) {
		this.urlToImage = urlToImage;
	}


	public String getPublishedAt() {
		return publishedAt;
	}


	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "ArticleModal [author=" + author + ", title=" + title + ", description=" + description + ", url=" + url
				+ ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + ", content=" + content + "]";
	}
	
	

}
