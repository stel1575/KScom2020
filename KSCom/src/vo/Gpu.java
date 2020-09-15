package vo;

public class Gpu {
	private int id;
	private String brand;
	private String chipset_maker;
	private String detail_chipset;
	private String vram;
	private String image;
	private String name;
	private int price;
	private String content;
	private int readcount;
	public Gpu(int id, String brand, String chipset_maker, String detail_chipset, String vram, String image,
			String name, int price, String content, int readcount) {
		this.id=id;
		this.brand=brand;
		this.chipset_maker=chipset_maker;
		this.detail_chipset=detail_chipset;
		this.vram=vram;
		this.image=image;
		this.name=name;
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
	public String getChipset_maker() {
		return chipset_maker;
	}
	public void setChipset_maker(String chipset_maker) {
		this.chipset_maker = chipset_maker;
	}
	public String getDetail_chipset() {
		return detail_chipset;
	}
	public void setDetail_chipset(String detail_chipset) {
		this.detail_chipset = detail_chipset;
	}
	public String getVram() {
		return vram;
	}
	public void setVram(String vram) {
		this.vram = vram;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	

