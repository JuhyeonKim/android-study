package kr.joao.android.study.listitemcheckex;


public class Food {
	
	private int img;
	
	private String title;
	
	private String contents;
	
	private boolean check;

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

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Food [img=" + img + ", title=" + title + ", contents="
				+ contents + ", check=" + check + "]";
	}

	public Food(String title, String contents, int img, boolean check) {
		super();
		this.img = img;
		this.title = title;
		this.contents = contents;
		this.check = check;
	}
	
	


}
