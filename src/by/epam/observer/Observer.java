package by.epam.observer;

import by.epam.entity.Cube;

public interface Observer {
    public void handleEvent(Cube cube);
}
