package cn.edu.csust.experiment.ex3;

public class Max {
	public static Comparable max(Comparable c1,Comparable c2){
		if( c1.compareTo(c2)>0)
			  return c1;
		else
			  return c2;
	}

}
