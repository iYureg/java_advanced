package ru.example.java.parsing.gson.adapters;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter
        implements JsonSerializer<ZonedDateTime>,
        JsonDeserializer<ZonedDateTime> {
    @Override
    public JsonElement serialize(ZonedDateTime zonedDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(zonedDateTime.toString());
    }

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return ZonedDateTime.parse(jsonElement.getAsString());
    }
}
