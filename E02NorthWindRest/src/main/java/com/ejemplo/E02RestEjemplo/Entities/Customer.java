package com.ejemplo.E02RestEjemplo.Entities;


import java.sql.Blob;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"id", 
	 			"supplier_ids", 
    		     "productCode", 
    		     "productName", 
                     "description", 
                     "standardCost", 
                     "listPrice", 
                     "reorderLevel", 
                     "targetLevel", 
                     "quantityPerUnit", 
                     "discontinued", 
                     "minimumReorderQuantity", 
                     "category", 
                     "attachments"})
public class Customer {
	private Integer id;
	private String supplier_ids;
	private String productCode;
	private String productName;
	private String description;
	private Double standardCost;
	private Double listPrice;
	private Integer reorderLevel;
	private Integer targetLevel;
	private String quantityPerUnit;
	private Boolean discontinued;
	private Integer minimumReorderQuantity;
	private String category;
	private Blob attachments;
	
	
	
	public Customer() {

	}

	public Customer(Integer id, String supplier_ids, String productCode, String productName, String description, Double standardCost,
			Double listPrice, Integer reorderLevel, Integer targetLevel, String quantityPerUnit, Boolean discontinued, Integer minimumReorderQuantity,
			String category, Blob attachments) {

		this.id = id;
		this.supplier_ids = supplier_ids;
		this.productCode = productCode;
		this.productName = productName;
		this.description = description;
		this.standardCost = standardCost;
		this.listPrice = listPrice;
		this.reorderLevel = reorderLevel;
		this.targetLevel = targetLevel;
		this.quantityPerUnit = quantityPerUnit;
		this.discontinued = discontinued;
		this.minimumReorderQuantity = minimumReorderQuantity;
		this.category = category;
		this.attachments = attachments;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public String getSupplier_ids() {
		return supplier_ids;
	}

	public void setSupplier_ids(String supplier_ids) {
		this.supplier_ids = supplier_ids;
	}
	
	public void setProductCode(String ProductCode) {
		this.productCode = ProductCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getStandardCost() {
		return standardCost;
	}

	public void setStandardCost(Double standardCost) {
		this.standardCost = standardCost;
	}
	
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	public Double getListPrice() {
		return listPrice;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setTargetLevel(Integer targetLevel) {
		this.targetLevel = targetLevel;
	}

	public Integer getTargetLevel() {
		return targetLevel;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}
	
	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
		this.minimumReorderQuantity = minimumReorderQuantity;
	}

	public Integer getMinimumReorderQuantity() {
		return minimumReorderQuantity;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}


	public Blob getAttachments() {
		return attachments;
	}

	public void setAttachment(Blob attachments) {
		this.attachments = attachments;
	}

	@Override
	public String toString() {
		return "Products [" + (id != null ? "id=" + id + ", " : "")
				+ (supplier_ids != null ? "supplier_ids=" + supplier_ids + ", " : "")
				+ (productCode != null ? "productCode=" + productCode + ", " : "")
				+ (productName != null ? "productName=" + productName + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (standardCost != null ? "standardCost=" + standardCost + ", " : "")
				+ (listPrice != null ? "listPrice=" + listPrice + ", " : "")
				+ (reorderLevel != null ? "reorderLevel=" + reorderLevel + ", " : "")
				+ (targetLevel != null ? "targetLevel=" + targetLevel : "") + "]"
				+ (quantityPerUnit != null ? "quantityPerUnit=" + quantityPerUnit + ", " : "")
				+ (discontinued != null ? "discontinued=" + discontinued + ", " : "")
				+ (minimumReorderQuantity != null ? "minimumReorderQuantity=" + minimumReorderQuantity : "")
				+ (category != null ? "category=" + category : "")
				+ (attachments != null ? "attachments=" + attachments : "") + "]";
	}

}



