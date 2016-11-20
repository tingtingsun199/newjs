package cn.edu.csust.experiment.ex3;
/**
 * Բ��
 * �����������
 * @author Admin
 *
 */

public class Circle4 extends GeometricObject1 implements Comparable{
	//extends��ʾ�̳и���
	private double radius;
	
	public Circle4() {
		
	}
	
	/**
	 * �вι��췽�����ð뾶����һ��Բ����
	 * @param radius
	 */
	public Circle4(double radius) {
		super();//super��ʾ����Ĺ��췽��
		this.radius = radius;
		}
	
	/**
	 * �вι��췽�����ð뾶����ɫ����䴴��һ��Բ���� 
	 * @param radius
	 * @param color
	 * @param filled
	 */
	public Circle4(double radius, String color, boolean filled) {
		super(color, filled); //��ʾ���ø�����вι��췽��
		this.radius = radius;
		/*
		setColor(color); //�����color��private�ģ�����ֻ����setter����
		setFilled(filled);//ͬ��
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
