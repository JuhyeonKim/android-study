package kr.joao.android.study.listadapterex;

import java.util.List;
import java.util.Map;

public class Food {
	
	private int img;
	
	private String title;
	
	private String contents;

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Food(String title, String contents,int img) {
		super();
		this.img = img;
		this.title = title;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Food [img=" + img + ", title=" + title + ", contents="
				+ contents + "]";
	}

}
