package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.Point;

public class CubeVerificationService extends CubeService{
    public boolean isSquare(Point point1, Point point2,Point point3,Point point4){
        double side1 = calculateDistanceBetweenPoints(point1,point2);
        double side2 = calculateDistanceBetweenPoints(point2,point3);
        double side3 = calculateDistanceBetweenPoints(point3,point4);
        double side4 = calculateDistanceBetweenPoints(point4,point1);
        double diagonal1 = calculateDistanceBetweenPoints(point1, point3);
        double diagonal2 = calculateDistanceBetweenPoints(point2,point4);
        boolean isSideLengthCorrect = (side1 == side2 && side1 == side3 && side1 == side4);
        boolean isDiagonalCorrect = (diagonal1 == diagonal2);
        return isDiagonalCorrect && isSideLengthCorrect;
    }

    public boolean isCubePoint(Cube cube){
        
    }

    public boolean isCube(Cube cube){
        boolean result = false;
        if(isSquare(cube.getPoint1(),cube.getPoint2(),cube.getPoint3(),cube.getPoint4())){
            if(isSquare(cube.getPoint5(), cube.getPoint6(), cube.getPoint7(), cube.getPoint8())){
                result = isSquare(cube.getPoint1(), cube.getPoint5(), cube.getPoint8(), cube.getPoint4());
            }
        }
        return result;
    }

}
