package by.epam.entity;

import java.util.UUID;

public abstract class AbstractShape {
    private final String shapeId;


    public AbstractShape() {
        this.shapeId = UUID.randomUUID().toString();
    }

    public String getShapeId() {
        return shapeId;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" [shapeId=");
        sb.append(shapeId);
        sb.append("]");
        return sb.toString();
    }
}
