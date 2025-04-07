
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


public String getType() {
	return type;
}

public String getTitle() {
	return title;
}


public String getDirector() {               //Métodos Get's
	return director;
}

public String[] getCast() {
	return cast;
}

public String getCountry() {
	return country;
}

public Date getDateAdded() {
	return date_added;
}


public int getReleaseYear() {
	return release_year;
}


public String getRating() {
	return rating;
}


public String getDuration() {
	return duration;
}

public String[] getListedIn() {
	return listed_in;
}



public void setShowId(String show_id) {
	this.show_id = show_id;
}

public void setType(String type) {
	this.type = type;
}

public void setTitle(String title) {
	this.title = title;
}

public void setDirector(String director) {             //Métodos Set's
	this.director = director;
}

public void setCast(String[] cast) {
	this.cast = cast;
}

public void setCountry(String country) {
	this.country = country;
}

public void setDateAdded(Date date_added) {
	this.date_added = date_added;
}

public void setReleaseYear(int release_year) {
	this.release_year = release_year;
}

public void setRating(String rating) {
	this.rating = rating;
}

public void setDuration(String duration) {
	this.duration = duration;
}

public void setListedIn(String[] listed_in) {
	this.listed_in = listed_in;
}


public Show clone() {
	Show novo = new Show();
	novo.show_id = this.show_id;
	novo.type = this.type;
	novo.title = this.type;
	novo.director = this.director;
	if(this.cast != null) {
		novo.cast = new String[this.cast.length];
		for(int i=0;i<this.cast.length;i++) {
			novo.cast[i] = this.cast[i];
		}
	}

	novo.country = this.country;

	if(this.date_added != null) {
		novo.date_added = (Date) this.date_added.clone();
	}

	novo.release_year = this.release_year;
	novo.rating = this.rating;
	novo.duration = this.duration;

	if(this.listed_in != null ) {
		novo.listed_in = new String[this.listed_in.length];
		for(int i=0;i<this.listed_in.length;i++) {
			novo.listed_in[i] = this.listed_in[i];
		}
	}
	return novo;
}


		
