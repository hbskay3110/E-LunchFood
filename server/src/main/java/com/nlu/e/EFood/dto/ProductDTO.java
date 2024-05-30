package com.nlu.e.EFood.dto;



import java.util.List;


public class ProductDTO {
    private Long id;
    private String description;
    private String urlImg;
    private String name;
    private Double price;
    private CategoryDTO type;
    private Boolean status;
    private DiscountDTO discount;
   

    public ProductDTO() {
        // Default constructor
    	this.discount = null;
    }

  

    // Getters and setters
    // Note: You can generate them automatically in most IDEs or manually like below

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public CategoryDTO getType() {
		return type;
	}
	public void setType(CategoryDTO type) {
		this.type = type;
	}
	public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DiscountDTO getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountDTO discount) {
        this.discount = discount;
    }

 
}
