package by.epam.specification.impl;

import by.epam.entity.Cube;
import by.epam.specification.Specification;

public class CubeIdSpecification implements Specification<Cube> {
    private final String id;

    public CubeIdSpecification(String id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return this.id == cube.getShapeId();
    }
}
