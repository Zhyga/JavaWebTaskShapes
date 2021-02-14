package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class CubeVerificationService extends CubeService {
    private final int sidesAtPoint = 3;

    public boolean isCubeByPoints(Cube cube) {//need to refactor
        Point point1 = cube.getPoint1();
        Point point2 = cube.getPoint2();
        Point point3 = cube.getPoint3();
        Point point4 = cube.getPoint4();
        Point point5 = cube.getPoint5();
        Point point6 = cube.getPoint6();
        Point point7 = cube.getPoint7();
        Point point8 = cube.getPoint8();
        List<Double> edges1 = new ArrayList<>();
        List<Double> edges2 = new ArrayList<>();
        List<Double> edges3 = new ArrayList<>();
        List<Double> edges4 = new ArrayList<>();
        List<Double> edges5 = new ArrayList<>();
        List<Double> edges6 = new ArrayList<>();
        List<Double> edges7 = new ArrayList<>();
        List<Double> edges8 = new ArrayList<>();
        List<List<Double>> edges = new ArrayList<>();

        edges1.add(calculateDistanceBetweenPoints(point1, point2));
        edges1.add(calculateDistanceBetweenPoints(point1, point3));
        edges1.add(calculateDistanceBetweenPoints(point1, point4));
        edges1.add(calculateDistanceBetweenPoints(point1, point5));
        edges1.add(calculateDistanceBetweenPoints(point1, point6));
        edges1.add(calculateDistanceBetweenPoints(point1, point7));
        edges1.add(calculateDistanceBetweenPoints(point1, point8));

        edges2.add(calculateDistanceBetweenPoints(point2, point1));
        edges2.add(calculateDistanceBetweenPoints(point2, point3));
        edges2.add(calculateDistanceBetweenPoints(point2, point4));
        edges2.add(calculateDistanceBetweenPoints(point2, point5));
        edges2.add(calculateDistanceBetweenPoints(point2, point6));
        edges2.add(calculateDistanceBetweenPoints(point2, point7));
        edges2.add(calculateDistanceBetweenPoints(point2, point8));

        edges3.add(calculateDistanceBetweenPoints(point3, point2));
        edges3.add(calculateDistanceBetweenPoints(point3, point1));
        edges3.add(calculateDistanceBetweenPoints(point3, point4));
        edges3.add(calculateDistanceBetweenPoints(point3, point5));
        edges3.add(calculateDistanceBetweenPoints(point3, point6));
        edges3.add(calculateDistanceBetweenPoints(point3, point7));
        edges3.add(calculateDistanceBetweenPoints(point3, point8));

        edges4.add(calculateDistanceBetweenPoints(point4, point2));
        edges4.add(calculateDistanceBetweenPoints(point4, point3));
        edges4.add(calculateDistanceBetweenPoints(point4, point1));
        edges4.add(calculateDistanceBetweenPoints(point4, point5));
        edges4.add(calculateDistanceBetweenPoints(point4, point6));
        edges4.add(calculateDistanceBetweenPoints(point4, point7));
        edges4.add(calculateDistanceBetweenPoints(point4, point8));

        edges5.add(calculateDistanceBetweenPoints(point5, point2));
        edges5.add(calculateDistanceBetweenPoints(point5, point3));
        edges5.add(calculateDistanceBetweenPoints(point5, point4));
        edges5.add(calculateDistanceBetweenPoints(point5, point1));
        edges5.add(calculateDistanceBetweenPoints(point5, point6));
        edges5.add(calculateDistanceBetweenPoints(point5, point7));
        edges5.add(calculateDistanceBetweenPoints(point5, point8));

        edges6.add(calculateDistanceBetweenPoints(point6, point2));
        edges6.add(calculateDistanceBetweenPoints(point6, point3));
        edges6.add(calculateDistanceBetweenPoints(point6, point4));
        edges6.add(calculateDistanceBetweenPoints(point6, point5));
        edges6.add(calculateDistanceBetweenPoints(point6, point1));
        edges6.add(calculateDistanceBetweenPoints(point6, point7));
        edges6.add(calculateDistanceBetweenPoints(point6, point8));

        edges7.add(calculateDistanceBetweenPoints(point7, point2));
        edges7.add(calculateDistanceBetweenPoints(point7, point3));
        edges7.add(calculateDistanceBetweenPoints(point7, point4));
        edges7.add(calculateDistanceBetweenPoints(point7, point5));
        edges7.add(calculateDistanceBetweenPoints(point7, point6));
        edges7.add(calculateDistanceBetweenPoints(point7, point1));
        edges7.add(calculateDistanceBetweenPoints(point7, point8));

        edges8.add(calculateDistanceBetweenPoints(point8, point2));
        edges8.add(calculateDistanceBetweenPoints(point8, point3));
        edges8.add(calculateDistanceBetweenPoints(point8, point4));
        edges8.add(calculateDistanceBetweenPoints(point8, point5));
        edges8.add(calculateDistanceBetweenPoints(point8, point6));
        edges8.add(calculateDistanceBetweenPoints(point8, point7));
        edges8.add(calculateDistanceBetweenPoints(point8, point1));

        edges.add(edges1);
        edges.add(edges2);
        edges.add(edges3);
        edges.add(edges4);
        edges.add(edges5);
        edges.add(edges6);
        edges.add(edges7);
        edges.add(edges8);
        Double minSide = edges1.get(0);
        for (int i = 0; i < edges.get(0).size(); i++) {
            Double side = edges.get(0).get(i);
            if (side < minSide) {
                minSide = side;
            }
        }
        int counter;
        int result = 0;
        for (int i = 0; i < edges.size(); i++) {
            counter = 0;
            for (int j = 0; j < edges.get(i).size(); j++) {
                Double side = edges.get(i).get(j);
                if (Double.compare(side, minSide) == 0) {
                    counter++;
                }
            }
            if (counter == sidesAtPoint) {
                result++;
            }
        }
        return result == 8;
    }

    public boolean isCubeBySides(Cube cube) {
        boolean result = false;
        if (isSquare(cube.getPoint1(), cube.getPoint2(), cube.getPoint3(), cube.getPoint4())) {
            if (isSquare(cube.getPoint5(), cube.getPoint6(), cube.getPoint7(), cube.getPoint8())) {
                result = isSquare(cube.getPoint1(), cube.getPoint5(), cube.getPoint8(), cube.getPoint4());
            }
        }
        return result;
    }

    private boolean isPointsInLine(Point point1, Point point2, Point point3) {
        boolean sideXY = (point3.getX() - point1.getX()) / (point2.getX() - point1.getX())
                == (point3.getY() - point1.getY()) / (point2.getY() - point1.getY());
        boolean sizeYZ = (point3.getY() - point1.getY()) / (point2.getY() - point1.getY())
                == (point3.getZ() - point1.getZ()) / (point2.getZ() - point1.getZ());
        if (!sideXY || !sizeYZ) {
            return false;
        }
        return true;
    }

    private boolean isSquare(Point point1, Point point2, Point point3, Point point4) {
        if (isPointsInLine(point1, point2, point3) &&
                isPointsInLine(point1, point2, point4)) {
            return false;
        }
        double side1 = calculateDistanceBetweenPoints(point1, point2);
        double side2 = calculateDistanceBetweenPoints(point2, point3);
        double side3 = calculateDistanceBetweenPoints(point3, point4);
        double side4 = calculateDistanceBetweenPoints(point4, point1);
        double diagonal1 = calculateDistanceBetweenPoints(point1, point3);
        double diagonal2 = calculateDistanceBetweenPoints(point2, point4);
        boolean isSideLengthCorrect = (side1 == side2 && side1 == side3 && side1 == side4);
        boolean isDiagonalCorrect = (diagonal1 == diagonal2);
        return isDiagonalCorrect && isSideLengthCorrect;
    }

}
