
import java.text.SimpleDateFormat;
import java.util.Date;

public class Show {
	private 
	String show_id;
	String type;
	String title;                                
	String director;
	String[] cast;
	String country;
	Date date_added;
	int release_year;
	String rating;
	String duration;
	String[]  listed_in;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



public Show() {
	show_id = "Nan";
	type = "Nan";
	title = "Nan";
	director = "Nan";
	country ="Nan";
	cast = null;
	date_added = null;
	release_year = 0;
	rating = "Nan";
	duration = "Nan";
	listed_in = new String[0];
	
	
}


public String getShowId() {
	return show_id;
}

public String setShowId(Strign show_id) {
	this.show_id = show_id;
}

public String getType() {
	return type;
}

public String setType(String type) {
	 this.type = type;
}

			
		
		
