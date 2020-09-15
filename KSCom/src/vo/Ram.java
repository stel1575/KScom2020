package vo;

public class Ram {
	private int id;
	private String brand;
	private String name;
	private String clock;
	private String capacity; //용량
	private String image;
	private int price;
	private String content;
	private int readcount;
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Ram(int id,String brand, String name, String clock, String capacity, String image , int price, String content
			,int readcount) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.brand=brand;
		this.name=name;
		this.clock=clock;
		this.capacity=capacity;
		this.image=image;
		this.price=price;
		this.content=content;
		this.readcount=readcount;
	}
	public int getReadcount() {
		return readcount;
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
	public String getClock() {
		return clock;
	}
	public void setClock(String clock) {
		this.clock = clock;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
}
