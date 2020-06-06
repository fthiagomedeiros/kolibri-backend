package br.com.kolibri.kolibri.airlines.route.handlers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends StdDeserializer<Date> {
    protected DateHandler(Class<?> vc) {
        super(vc);
    }

    protected DateHandler(JavaType valueType) {
        super(valueType);
    }

    protected DateHandler(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        try {
            String date = jsonParser.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return sdf.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }
}
