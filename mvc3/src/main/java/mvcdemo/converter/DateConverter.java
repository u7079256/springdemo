package mvcdemo.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String dataStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
