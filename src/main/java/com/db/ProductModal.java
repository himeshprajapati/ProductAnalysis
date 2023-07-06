package com.db;

public class ProductModal {
		private int id;
        private String productName;
        private String functionality;
        private String performance;
        private String usability;
        private String cost;
        private String value;
        private String environmentalImpact;
        
		public ProductModal(int id, String productName, String functionality, String performance, String usability,
				String cost, String value, String environmentalImpact) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.productName = productName;
			this.functionality = functionality;
			this.performance = performance;
			this.usability = usability;
			this.cost = cost;
			this.value = value;
			this.environmentalImpact = environmentalImpact;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getFunctionality() {
			return functionality;
		}
		public void setFunctionality(String functionality) {
			this.functionality = functionality;
		}
		public String getPerformance() {
			return performance;
		}
		public void setPerformance(String performance) {
			this.performance = performance;
		}
		public String getUsability() {
			return usability;
		}
		public void setUsability(String usability) {
			this.usability = usability;
		}
		public String getCost() {
			return cost;
		}
		public void setCost(String cost) {
			this.cost = cost;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getEnvironmentalImpact() {
			return environmentalImpact;
		}
		public void setEnvironmentalImpact(String environmentalImpact) {
			this.environmentalImpact = environmentalImpact;
		}
}
