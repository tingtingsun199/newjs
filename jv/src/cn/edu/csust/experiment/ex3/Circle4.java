package cn.edu.csust.experiment.ex3;
/**
 * 圆类
 * 几何类的子类
 * @author Admin
 *
 */

public class Circle4 extends GeometricObject1 implements Comparable{
	//extends表示继承父类
	private double radius;
	
	public Circle4() {
		
	}
	
	/**
	 * 有参构造方法，用半径创建一个圆对象
	 * @param radius
	 */
	public Circle4(double radius) {
		super();//super表示父类的构造方法
		this.radius = radius;
		}
	
	/**
	 * 有参构造方法，用半径，颜色，填充创建一个圆对象 
	 * @param radius
	 * @param color
	 * @param filled
	 */
	public Circle4(double radius, String color, boolean filled) {
		super(color, filled); //表示调用父类的有参构造方法
		this.radius = radius;
		/*
		setColor(color); //父类的color是private的，所以只能用setter设置
		setFilled(filled);//同上
		*/
	  }

	  /** Return radius */
	  public double getRadius() {
	    return radius;
	  }
	
	  /** Set a new radius */
	  public void setRadius(double radius) {
	    this.radius = radius;
	  }
	
	  /** Return area */
	  public double getArea() {
	    return radius * radius * Math.PI;
	  }
	  
	  /** Return diameter */
	  public double getDiameter() {
	    return 2 * radius;
	  }
	  
	  /** Return perimeter */
	  public double getPerimeter() {
	    return 2 * radius * Math.PI;
	  }
	
	  /* Print the circle info */
	  public void printCircle() {
	    System.out.println(toString() + "The circle is created " + getDateCreated() +
	      " and the radius is " + radius);
	  }
	  
	  public String toString() {
	    return "Circle: radius" + getRadius()+" " + super.toString();
	  }

	@Override
	public int compareTo(Object c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
