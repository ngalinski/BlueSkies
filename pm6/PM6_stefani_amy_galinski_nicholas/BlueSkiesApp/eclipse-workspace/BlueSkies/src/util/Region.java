package util;

public enum Region {
	  SOUTHWEST("Southwest"), 
	  SOUTHEAST("Southeast"), 
	  WEST("West"), 
	  MOUNTAIN("Mountain"),
	  NORTHEAST("Northeast"),
	  NORTHWEST("Northwest");

	  private String string;
	  
	  	Region(String string) {
	      this.string = string;
		}

		public String getString() {
	      return string;
		}
		
		public static Region fromString(String string) {
			switch(string) {
			   case "Southwest":
			      return Region.SOUTHWEST; 
		
			   case "Southeast":
				  return Region.SOUTHEAST; 
				      
			   case "West":
				  return Region.WEST; 
				     
			   case "Mountain":
				  return Region.MOUNTAIN;
				     
			   case "Northeast":
					return Region.NORTHEAST;
					
			   case "Northwest":
					return Region.NORTHWEST;
				  
				default:
					return null;
			}
		}
	}

