package by.epam.service;

import by.epam.entity.CustomPoint;

public abstract class CubeService {
    public double calculateDistanceBetweenPoints(
            CustomPoint firstPoint, CustomPoint secondPoint) {
        double distanceX = firstPoint.getX() - secondPoint.getX();
        double distanceY = firstPoint.getY() - secondPoint.getY();
        double distanceZ = firstPoint.getZ() - secondPoint.getZ();
        double distanceBetweenPoints = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2));
        return distanceBetweenPoints;
    }

    public double calculateDiagonalViaSide(CustomPoint firstPoint, CustomPoint secondPoint) {
        double diagonal = calculateDistanceBetweenPoints(firstPoint, secondPoint) * Math.sqrt(2);
        return diagonal;
    }

}
