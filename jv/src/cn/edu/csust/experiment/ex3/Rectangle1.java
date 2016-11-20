package cn.edu.csust.experiment.ex3;
/**
 * 矩形类
 * @author Admin
 *
 */
public class Rectangle1 extends GeometricObject1  implements Comparable {
  private double width;//宽
  private double height;//高

  /**
   * 无参构造方法
   */
  public Rectangle1() {
  }

  /**
   * 用宽和高构建一个对象
   * @param width
   * @param height
   */
  public Rectangle1(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * 有参构造方法
   * @param width 宽
   * @param height 高
   * @param color 颜色
   * @param filled 填充
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
