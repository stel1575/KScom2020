package vo;

public class Mainboard {
	
	private int id;
	private String brand;
	private String name;
	private String kind;
	private String socket;
	private String chipset;
	private String form_factor;
	private String image;
	private int price;
	private String content;
	private int readcount;
	public Mainboard(int id, String brand, String name, String kind, String socket, String chipset,
			String form_factor, String image, int price, String content, int readcount) {
		this.id=id;
		this.brand=brand;
		this.name=name;
		this.kind=kind;
		this.socket=socket;
		this.chipset=chipset;
		this.form_factor=form_factor;
		this.image=image;
		this.price=price;
		this.content=content;
		this.readcount=readcount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getChipset() {
		return chipset;
	}
	public void setChipset(String chipset) {
		this.chipset = chipset;
	}
	public String getForm_factor() {
		return form_factor;
	}
	public void setForm_factor(String form_factor) {
		this.form_factor = form_factor;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

}
