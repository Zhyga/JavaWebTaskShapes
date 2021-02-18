package by.epam.entity;

public class CubeDataHandler {
    private double surfaceArea;
    private double volume;

    public CubeDataHandler(){}

    public CubeDataHandler(double surfaceArea, double volume){
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeDataHandler cubeDataHandler = (CubeDataHandler) o;
        return Double.compare(cubeDataHandler.surfaceArea, surfaceArea) == 0 &&
                Double.compare(cubeDataHandler.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = result * 37 + Double.valueOf(surfaceArea).hashCode();
        result = result * 37 + Double.valueOf(volume).hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CubeData{");
        sb.append("perimeter= ").append(surfaceArea);
        sb.append("square= ").append(volume);
        sb.append("}");
        return sb.toString();
    }
}
