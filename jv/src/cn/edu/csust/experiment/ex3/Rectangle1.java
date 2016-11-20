package cn.edu.csust.experiment.ex3;
/**
 * ������
 * @author Admin
 *
 */
public class Rectangle1 extends GeometricObject1  implements Comparable {
  private double width;//��
  private double height;//��

  /**
   * �޲ι��췽��
   */
  public Rectangle1() {
  }

  /**
   * �ÿ�͸߹���һ������
   * @param width
   * @param height
   */
  public Rectangle1(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * �вι��췽��
   * @param width ��
   * @param height ��
   * @param color ��ɫ
   * @param filled ���
   */
  public Rectangle1(double width, double height, String color, 
      boolean filled) {
    this.width = width;
    this.height = height;
    setColor(color);
    setFilled(filled);
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  /** Return area */
  public double getArea() {
    return width * height;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }

@Override
public int compareTo(Object c) {
	// TODO Auto-generated method stub
	return 0;
}
}
