package ie.daniel.codechallege.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "beer")
	public class Beer {
		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		private String name;
		private String description;
		private double percentage;
		private String location;	
		
		
		public Beer(){
			
			
		}
		
		public Beer(Integer id, String name, String description, double percentage, String location) {
			
			this.id = id;
			this.name = name;
			this.description = description;
			this.percentage = percentage;
			this.location = location;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPercentage() {
			return percentage;
		}
		public void setPercentage(double percentage) {
			this.percentage = percentage;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getId() {
			return id;
		}
		

}
