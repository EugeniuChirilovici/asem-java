import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class Elev{
	private int point;
	private String name;
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Elev(int point,String name) {
		this.point=point;
		this.name=name;
	}
	public String show_point_name() {
		return point+"\t "+name+"\t";
	}
}

class Average extends Elev{
	private double average;
	public Average(int point,String name,double average) {
		super(point, name);
		this.average=average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public double getAverage() {
		return average;
	}
	public String toString() {
		return show_point_name()+" \t"+average;
	}
}

abstract class Inform{
	public abstract void introduction(ArrayList<Average> e);
	public abstract void random(ArrayList<Average> e);
	public abstract double probability(ArrayList<Average> e, int id);
	public abstract void rang(double rang);
}

class GoodPerson extends Inform{
	private Scanner input;
	public void introduction(ArrayList<Average> e) {
		input = new Scanner(System.in);
		System.out.println("Enter your name please");
		String name = input.nextLine();
		System.out.println("How many points you have accumulated at test?");
		int point= input.nextInt();
		System.out.println("What is your score?");
		double average= input.nextDouble();
		e.add(new Average(point,name,average));
	}
	public void random(ArrayList<Average> e) {
		int number_competitors = 9;
		int yourNumber = 9; 
		Random randomGenerator = new Random();
		int rand = randomGenerator.nextInt(number_competitors);
		if(probability(e,yourNumber)>probability(e,rand)) {
			System.out.println(e.get(yourNumber).getName()+"("+probability(e,yourNumber)+"%)"+" has more probability to win than the "+
					e.get(rand).getName()+"("+probability(e,rand)+"%)");
			
		}
		else {
			System.out.println(e.get(yourNumber).getName()+"("+probability(e,yourNumber)+"%)"+" has less probability to win than the "+
					e.get(rand).getName()+"("+probability(e,rand)+"%)");
		}
	}
	public double probability(ArrayList<Average> e, int id) {
		double averagePoint = e.get(id).getPoint()*100/31;
		double averageScore = e.get(id).getAverage()*100/10;
		return (averagePoint+averageScore)/2;
	}
	public void rang (double rang) {
		System.out.println("Military grades");
		if(rang<=10) {
			System.out.println("You are Second Lieutenant");
		}
		else if(rang<=20) {
			System.out.println("You are First Lieutenant");
		}
		else if(rang<=30) {
			System.out.println("You are Captain");
		}
		else if(rang<=40) {
			System.out.println("You are Major");
		}
		else if(rang<=50) {
			System.out.println("You are Lieutenant Colonel");
		}
		else if(rang<=60) {
			System.out.println("You are Colonel");
		}
		else if(rang<=70) {
			System.out.println("You are Brigadier General");
		}
		else if(rang<=80) {
			System.out.println("You are Major General");
		}
		else if(rang<=90) {
			System.out.println("You are Lieutenant General");
		}
		else if(rang<=100) {
			System.out.println("You are General");
		}
	}
}

public class Details {
	public static void main (String[] args) {
		ArrayList<Average> e = new ArrayList<Average>();
		e.add(new Average(10,"Ion",5.11));
		e.add(new Average(15,"Nicu",8.3));
		e.add(new Average(29,"Andrei",7.98));
		e.add(new Average(12,"Valentin",2.55));
		e.add(new Average(9,"Ana-Maria",6.33));
		e.add(new Average(26,"Diana",4.75));
		e.add(new Average(13,"Cristi",2.99));
		e.add(new Average(30,"Denis",7.73));
		e.add(new Average(7,"Danu",9.05));
		GoodPerson person = new GoodPerson();
		person.introduction(e);
		person.random(e);
		person.rang(person.probability(e,9));
		System.out.println("\nHere you see your place in top (sort after Score)");
		System.out.println("Poits\tName\tScore");
		Collections.sort(e, new Comparator<Average>() {
			public int compare(Average a1, Average a2) {
				if(a1.getAverage()>a2.getAverage()) {
					return -1;
				}
				else if(a1.getAverage()<a2.getAverage()) {
					return 1;
				}
				return 0;
			}
		});
		for(Elev s: e) {
			System.out.println(s);
		}
		
		System.out.println("\nHere you see your place in top (sort after Points)");
		System.out.println("Poits\tName\tScore");
		Collections.sort(e, new Comparator<Elev>() {
			public int compare(Elev e1, Elev e2) {
				if(e1.getPoint()>e2.getPoint()) {
					return -1;
				}
				else if(e1.getPoint()<e2.getPoint()) {
					return 1;
				}
				return 0;
			}
		});
		for(Elev s: e) {
			System.out.println(s);
		}
	}
}
