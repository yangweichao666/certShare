//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.component;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

public class SpringfoxJsonToGsonSerializer implements JsonSerializer<Json> {
    public SpringfoxJsonToGsonSerializer() {
    }

    public JsonElement serialize(Json json, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(json.value());
    }
}
