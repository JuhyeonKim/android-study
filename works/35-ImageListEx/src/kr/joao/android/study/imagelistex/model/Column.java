package kr.joao.android.study.imagelistex.model;

public class Column {
	
	private int num;
	
	private String img;
	
	private String subject;
	
	private String contents;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Column [num=" + num + ", img=" + img + ", subject=" + subject
				+ ", contents=" + contents + "]";
	}

	public Column(int num, String img, String subject, String contents) {
		super();
		this.num = num;
		this.img = img;
		this.subject = subject;
		this.contents = contents;
	}
	
}
