package org.example.config;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    public Map<String, Object> scenarioContext = new HashMap<>();


    public void put(String key, Object value){
        scenarioContext.put(key, value);

    }

    public Object get(String key){
        return scenarioContext.get(key);
    }
}
