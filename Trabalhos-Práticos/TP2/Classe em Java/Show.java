
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
	show_id = "";
	type = "";
	title = "";
	director = "";
	country ="";
	cast = null;
	date_added = null;
	release_year = 0;
	rating = "";
	duration = "";
	listed_in = new String[0];
	

	
}



			
		
		
