package vo;

public class Cpu {
	
	private int id;
	private String name;
	private String core;
	private String cpu_package;
	private String image;
	private int price;
	private String content;
	private int readcount;
	
	public Cpu(int id, String name,  String core, String cpu_package, String image, int price, String content,
			int readcount) {
		this.id= id;
		this.name=name;
		this.core=core;
		this.cpu_package=cpu_package;
		this.image=image;
		this.price=price;
		this.content=content;
		this.readcount=readcount;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	public String getCpu_package() {
		return cpu_package;
	}
	public void setCpu_package(String cpu_package) {
		this.cpu_package = cpu_package;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	
}
	
