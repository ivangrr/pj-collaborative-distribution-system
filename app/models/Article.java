package models;

import java.util.List;

public class Article{
	public String code;	
	
	public String name;
	public String description;
	public List<String> category;
	public List<String> assort;
	public List<String> brand;
	
	@Override
	public String toString() {
		return "Article [code=" + code + ", name=" + name + ", description="
				+ description + ", category=" + category + ", assort=" + assort
				+ ", brand=" + brand + "]";
	}
}
