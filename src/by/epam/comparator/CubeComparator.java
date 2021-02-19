package by.epam.comparator;

import by.epam.entity.Cube;
import by.epam.exception.CustomException;
import by.epam.service.CubeMathService;

import java.util.Comparator;

public enum CubeComparator implements Comparator<Cube> {
    ID {
        @Override
        public int compare(Cube o1, Cube o2) {
            return o1.getShapeId().compareTo(o2.getShapeId());
        }
    },
    POINT1 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint1().getX() - o2.getPoint1().getX();
            double yValue = o1.getPoint1().getY() - o2.getPoint1().getY();
            double zValue = o1.getPoint1().getZ() - o2.getPoint1().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT2 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint2().getX() - o2.getPoint2().getX();
            double yValue = o1.getPoint2().getY() - o2.getPoint2().getY();
            double zValue = o1.getPoint2().getZ() - o2.getPoint2().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT3 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint3().getX() - o2.getPoint3().getX();
            double yValue = o1.getPoint3().getY() - o2.getPoint3().getY();
            double zValue = o1.getPoint3().getZ() - o2.getPoint3().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT4 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint4().getX() - o2.getPoint4().getX();
            double yValue = o1.getPoint4().getY() - o2.getPoint4().getY();
            double zValue = o1.getPoint4().getZ() - o2.getPoint4().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT5 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint5().getX() - o2.getPoint5().getX();
            double yValue = o1.getPoint5().getY() - o2.getPoint5().getY();
            double zValue = o1.getPoint5().getZ() - o2.getPoint5().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT6 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint6().getX() - o2.getPoint6().getX();
            double yValue = o1.getPoint6().getY() - o2.getPoint6().getY();
            double zValue = o1.getPoint6().getZ() - o2.getPoint6().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT7 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint7().getX() - o2.getPoint7().getX();
            double yValue = o1.getPoint7().getY() - o2.getPoint7().getY();
            double zValue = o1.getPoint7().getZ() - o2.getPoint7().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    POINT8 {
        @Override
        public int compare(Cube o1, Cube o2) {
            double xValue = o1.getPoint8().getX() - o2.getPoint8().getX();
            double yValue = o1.getPoint8().getY() - o2.getPoint8().getY();
            double zValue = o1.getPoint8().getZ() - o2.getPoint8().getZ();
            int result = (int) (xValue + yValue + zValue);
            return result;
        }
    },
    VOLUME {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubeMathService cubeMathService = new CubeMathService();
            double volume1 = 0;
            double volume2 = 0;
            try {
                 volume1 = cubeMathService.calculateVolume(o1);
                 volume2 = cubeMathService.calculateVolume(o2);
            } catch (CustomException e) {
                e.printStackTrace();
            }
            return (int)(volume1-volume2);
        }
    },
    SURFACEAREA {
        @Override
        public int compare(Cube o1, Cube o2) {
            CubeMathService cubeMathService = new CubeMathService();
            double surfaceArea1 = 0;
            double surfaceArea2 = 0;
            try {
                surfaceArea1 = cubeMathService.calculateSurfaceArea(o1);
                surfaceArea2 = cubeMathService.calculateSurfaceArea(o2);
            } catch (CustomException e) {
                e.printStackTrace();
            }
            return (int)(surfaceArea1-surfaceArea2);
        }
    };
}
