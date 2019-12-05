package json;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> jsonPairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.jsonPairs = new ArrayList<JsonPair>();
        for (JsonPair pair : jsonPairs) {
            this.add(pair);
        }
    }

    @Override
    public String toJson() {
        if (jsonPairs.size() < 1) {
            return "{}";
        }
        StringBuilder res = new StringBuilder("{");
        for (JsonPair pair : jsonPairs) {
            res.append("'" + pair.key + "'").append(":").append(pair.value.toJson()).append(",");
        }
        res.replace(res.length() - 1, res.length(), "}");
        return res.toString();
    }

    public void add(JsonPair jsonPair) {
        int copyIndex = jsonPairs.indexOf(jsonPair);
        if (copyIndex == -1) {
            jsonPairs.add(jsonPair);
        } else {
            jsonPairs.set(copyIndex, jsonPair);
        }
    }

    public Json find(String name) {
        for (JsonPair pair : jsonPairs) {
            if (pair.key.equals(name)) {
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject result = new JsonObject();
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names));
        for (JsonPair pair : jsonPairs) {
            if (nameList.contains(pair.key)) {
                result.add(pair);
            }
        }
        return result;
    }
}
