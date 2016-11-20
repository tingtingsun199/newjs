package cn.edu.csust.experiment.ex3;
/**
 * ������
 * ����������״�ĸ���
 * @author Admin
 *
 */
public class GeometricObject1   implements Comparable{
	

  private String color = "white";//Ĭ����ɫ��ɫ
  private boolean filled;
  private java.util.Date dateCreated;//����������
  
  /** ����һ��Ĭ�ϵļ��ζ��� */
  public GeometricObject1() {
    dateCreated = new java.util.Date();
  }
 
  /**
   * ����һ�����ζ���
   * @param color
   * @param filled
   */
  public GeometricObject1(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean, 
     its get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }
  
  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }
  
  /** Return a string representation of this object */
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color + 
      " and filled: " + filled;
  }

public static Comparable max(Comparable c1,Comparable  c2) {
	if( c1.compareTo(c2)>0)
		  return  c1;
	else
		  return c2;
}



}
