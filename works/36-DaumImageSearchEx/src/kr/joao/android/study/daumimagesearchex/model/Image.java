package kr.joao.android.study.daumimagesearchex.model;

public class Image {
	
	public static int totalCount;
	public static int pageCount;
	public static int result;
	
	private String title;
	private String link;
	private String thumbnail;
	private int width;
	private int height;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Image(String title, String link, String thumbnail, int width,
			int height) {
		super();
		this.title = title;
		this.link = link;
		this.thumbnail = thumbnail;
		this.width = width;
		this.height = height;
	}
	@Override
	public String toString() {
		return "Image [title=" + title + ", link=" + link + ", thumbnail="
				+ thumbnail + ", width=" + width + ", height=" + height + "]";
	}
	
	
	

}
