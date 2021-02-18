package by.epam.warehouse;

import by.epam.entity.CubeDataHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CubeWarehouse {
    private static CubeWarehouse instance;
    private static Map<String, CubeDataHandler> cubeData = new HashMap<>();

    public static CubeWarehouse getInstance(){
        if(instance == null){
            instance = new CubeWarehouse();
        }
        return instance;
    }

    public CubeDataHandler get(String key){
        return cubeData.get(key);
    }

    public CubeDataHandler put(String key,CubeDataHandler value){
        return cubeData.put(key,value);
    }

    public CubeDataHandler remove(String key){
        return cubeData.remove(key);
    }

    public static Map<String, CubeDataHandler> getCubeData() {
        return Collections.unmodifiableMap(cubeData);
    }
}
