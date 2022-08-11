//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

@Component
public class CustomizedGsonHttpMessageConverter extends GsonHttpMessageConverter {
    public CustomizedGsonHttpMessageConverter() {
        this.setGson(this.gson());
    }

    private Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Json.class, new SpringfoxJsonToGsonSerializer());
        return gsonBuilder.create();
    }
}
