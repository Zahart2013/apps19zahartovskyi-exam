package domain;

import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name", new JsonString(name)));
        jsonObject.add(new JsonPair("surname", new JsonString(surname)));
        jsonObject.add(new JsonPair("year", new JsonNumber(year)));
        JsonArray arr = new JsonArray();
        for(Tuple<String, Integer> exam: exams){

        }
        return jsonObject;
    }
}
