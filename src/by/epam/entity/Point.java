package by.epam.entity;

import java.util.UUID;

public class Point {
    private final String pointId;
    private double x;
    private double y;
    private double z;

    public Point(double x, double y,double z){
        pointId = UUID.randomUUID().toString();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getPointId() {
        return pointId;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        if (pointId != point.pointId) {
            return false;
        }
        if (Double.compare(x, point.x) != 0) {
            return false;
        }
        if (Double.compare(y, point.y) != 0) {
            return false;
        }
        if (Double.compare(z, point.z) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 11 + (pointId != null ? pointId.hashCode() : 0);
        result = result * 11 + Double.valueOf(x).hashCode();
        result = result * 11+ Double.valueOf(y).hashCode();
        result = result * 11 + Double.valueOf(z).hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("pointId=").append(pointId);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", z=").append(z);
        sb.append('}');
        return sb.toString();
    }
}
