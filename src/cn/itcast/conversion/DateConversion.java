package cn.itcast.conversion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConversion implements Converter<String, Date> {


	public Date convert(String dateString) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
