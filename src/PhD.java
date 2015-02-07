//I checked the Javadoc output and it was OK.
/** An instance maintains info about the PhD of a person. */
public class PhD {
	private String name;  //Name of the person with a PhD, a String of length > 0
	private int year; //Year PhD was awarded
	private int month; //Month PhD was awarded. In range 1..12 with 1 being 
						//January, etc
	private char gender; //Gender of the person. 'M' means male and 'F' means 
						//female
	private PhD advisor1; //First advisor of this person. The first PhD advisor
							//of this person —null if unknown.
	private PhD advisor2; //Second advisor of this person. The second advisor
	        //of this person —null if unknown or if the person had only one
		    //advisor. If the first-advisor field is null, the second advisor
		    //field must be null.
	private int advisees; //Number of PhD advisees of this person.
	
	/** Constructor: an instance for a person with name n, gender g, PhD year y,
     *  and PhD month m. Its advisors are unknown, and it has no advisees.
     *  Precondition: n has at least 1 character, m is in 1..12, and g is 'M' 
	 *  for male or 'F' for female. */
	public PhD(String n, char g,int y, int m){
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		assert g == 'M' || g == 'F';
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = null;
		advisor2 = null;
		advisees = 0;
	}
	
	/** Constructor: a PhD with name n, gender g, PhD year y, PhD month m, 
     *  first advisor ad, and no second advisor.
     *  Precondition: n has at least 1 char, g is 'F' for female or 'M' for male,
     *  m is in 1..12, and ad is not null.*/
	public PhD(String n, char g, int y, int m, PhD ad){
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		assert g == 'M' || g == 'F';
		assert ad != null;
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = ad;
		advisor2 = null;
		advisees = 0;
		ad.advisees = ad.advisees + 1;
	}
	
	/** Constructor: a PhD with name n, gender g, PhD year y, PhD month m, first
     *  advisor ad1, and second advisor ad2.
     *  Precondition: n has at least 1 char, g is 'F' for female or 'M' for male, 
     *  m is in 1..12, ad1 and ad2 are not null, and ad1 and ad2 are different.*/
	public PhD(String n, char g, int y, int m, PhD ad1, PhD ad2){
		assert n != null && n.length() >= 1;
		assert m >= 1 && m <= 12;
		assert g == 'M' || g == 'F';
		assert ad1 != null;
		assert ad2 != null && ad2 != ad1;
		name = n;
		gender = g;
		year = y;
		month = m;
		advisor1 = ad1;
		advisor2 = ad2;
		advisees = 0;
		ad1.advisees = ad1.advisees + 1;
		ad2.advisees = ad2.advisees + 1;
	}
	
	/** Return this person's name.*/
	public String getName(){
		return name;
	}
	
	/** Return the year this person got their PhD.*/
	public int getYear(){
		return year;
	}
	
	/** Return the month this person got their PhD.*/
	public int getMonth(){
		return month;
	}
	
	/** Return the value of "this person is a female".*/
	public boolean isFemale(){
		return gender == 'F';
	}
	
	/** Return this Phd's first advisor (null if unknown)*/
	public PhD getAdvisor1(){
		return advisor1;
	}
	
	/** Return this PhD's second advisor (null if unknown or nonexistent).*/
	public PhD getAdvisor2(){
		return advisor2;
	}
	
	/** Return the number of PhD advisees of this person.*/
	public int numAdvisees(){
		return advisees;
	}
	
	/** Add p as this person's first PhD advisor.
     *  Precondition: this person's first advisor is unknown and p is not null.*/
	public void addAdvisor1(PhD p){
		assert advisor1 == null;
		assert p != null;
		advisor1 = p;
		p.advisees = p.advisees + 1;
	}
	
	/** Add p as this persons second advisor.
	 *  Precondition: This person's first advisor is known, their second advisor
	 *  is unknown, p is not null, and p is different from this person's first 
	 *  advisor.*/
	public void addAdvisor2(PhD p){
		assert advisor1 != null;
		assert advisor2 == null;
		assert p != null;
		assert p != advisor1;
		advisor2 = p;
		p.advisees = p.advisees + 1;
	}
	
	/** Return value of "this person got their PhD before p did."
	 *  Precondition: p is not null.*/
	public boolean isOlderThan(PhD p){
		assert p != null;
		return year < p.year || (year == p.year && month < p.month);	
	}
	
	/** Return value of "this person and p are intellectual siblings.”
     *  Precondition: p is not null.*/
	public boolean isPhDSibling(PhD p){
		assert p != null;
		return (((advisor1 == p.advisor1 || advisor1 == p.advisor2)
				&& advisor1 != null) || ((advisor2 == p.advisor1 || 
				advisor2 == p.advisor2) && advisor2 != null));
	}
}