package by.epam.entity;

/*
*   Point1       Point2
*
*         Square
*
*   Point3       Point4
* */

import java.util.List;

public class Cube extends Shape{
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Point point5;
    private Point point6;
    private Point point7;
    private Point point8;
    public Cube(Point point1,Point point2,Point point3,Point point4,Point point5,Point point6,Point point7,Point point8){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
        this.point6 = point6;
        this.point7 = point7;
        this.point8 = point8;
    }

    public Cube(List<Point> pointList){
        this.point1 = pointList.get(0);
        this.point2 = pointList.get(1);
        this.point3 = pointList.get(2);
        this.point4 = pointList.get(3);
        this.point5 = pointList.get(4);
        this.point6 = pointList.get(5);
        this.point7 = pointList.get(6);
        this.point8 = pointList.get(7);
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }

    public Point getPoint5() {
        return point5;
    }

    public void setPoint5(Point point5) {
        this.point5 = point5;
    }

    public Point getPoint6() {
        return point6;
    }

    public void setPoint6(Point point6) {
        this.point6 = point6;
    }

    public Point getPoint7() {
        return point7;
    }

    public void setPoint7(Point point7) {
        this.point7 = point7;
    }

    public Point getPoint8() {
        return point8;
    }

    public void setPoint8(Point point8) {
        this.point8 = point8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        if(point1 == null || cube.point1 == null || !cube.point1.equals(point1)){
            return false;
        }
        if(point2 == null || cube.point2 == null || !cube.point2.equals(point2)){
            return false;
        }
        if(point3 == null || cube.point3 == null || !cube.point3.equals(point3)){
            return false;
        }
        if(point4 == null || cube.point4 == null || !cube.point4.equals(point4)){
            return false;
        }
        if(point5 == null || cube.point5 == null || !cube.point5.equals(point5)){
            return false;
        }
        if(point6 == null || cube.point6 == null || !cube.point6.equals(point6)){
            return false;
        }
        if(point7 == null || cube.point7 == null || !cube.point7.equals(point7)){
            return false;
        }
        if(point8 == null || cube.point8 == null || !cube.point8.equals(point8)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 107 + (point1 != null ? point1.hashCode() : 0);
        result = result * 107 + (point2 != null ? point2.hashCode() : 0);
        result = result * 107 + (point3 != null ? point3.hashCode() : 0);
        result = result * 107 + (point4 != null ? point4.hashCode() : 0);
        result = result * 107 + (point5 != null ? point5.hashCode() : 0);
        result = result * 107 + (point6 != null ? point6.hashCode() : 0);
        result = result * 107 + (point7 != null ? point7.hashCode() : 0);
        result = result * 107 + (point8 != null ? point8.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("\nCube=").append(getShapeId());
        sb.append(",\n point1=").append(point1);
        sb.append(",\n point2=").append(point2);
        sb.append(",\n point3=").append(point3);
        sb.append(",\n point4=").append(point4);
        sb.append(",\n point5=").append(point5);
        sb.append(",\n point6=").append(point6);
        sb.append(",\n point7=").append(point7);
        sb.append(",\n point8=").append(point8);
        sb.append("\n}");
        return sb.toString();
    }
}
