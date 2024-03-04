
public class Article {
	private Integer num;
	private String title;
	private String content;
	private String writer;
	
	public Article() {}
	
	public Article(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public Article(Integer num, String title, String content, String writer) {
		super();
		this.num=num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return String.format("글번호 : %s, 제목 : %s, 내용 : %s, 작성자 : %s", num, title, content, writer);
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
