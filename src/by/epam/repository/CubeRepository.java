package by.epam.repository;

import by.epam.entity.Cube;
import by.epam.specification.Specification;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CubeRepository {
    private static CubeRepository instance;
    private static List<Cube> cubes = new ArrayList<>();

    private CubeRepository() {
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public List<Cube> query(Specification<Cube> specification) {
        return cubes.stream().filter(c -> specification.specify(c))
                .collect(Collectors.toList());
    }

    public List<Cube> sort(Comparator<Cube> comparator) {
        return cubes.stream().sorted(comparator).collect(Collectors.toList());
    }

    public boolean add(Cube cube) {
        return cubes.add(cube);
    }

    public boolean remove(Cube cube) {
        return cubes.remove(cube);
    }

    public List<Cube> getAll() {
        return Collections.unmodifiableList(cubes);
    }

}
