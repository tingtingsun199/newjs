package cn.edu.csust.experiment.ex3;
public class TestCircleRectangle {
  public static void main(String[] args) {
    Circle4 circle = new Circle4(3);
    Rectangle1 rectangle = new Rectangle1(6, 6);
    System.out.println( circle);
    System.out.println( rectangle);
    System.out.println("A circle " + circle.toString());
    
    System.out.println("The area is " + circle.getArea());
    System.out.println("The diameter is " + circle.getDiameter());
    System.out.println("面积较大的是"+GeometricObject1.max( c1,c2));
    circle.setRadius(6);
    rectangle.setHeight(3);
    rectangle.setWidth(3);
   System.out.println("面积较大的是"+GeometricObject1.max( circle,rectangle));

    System.out.println( circle);
    System.out.println( rectangle);
    System.out.println("\nA rectangle " + rectangle.toString());
    System.out.println("The area is " + rectangle.getArea());
    System.out.println("The perimeter is " +
      rectangle.getPerimeter());
  }
}
