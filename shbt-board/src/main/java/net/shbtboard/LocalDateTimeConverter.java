package net.shbtboard;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
		// TODO Auto-generated method stub
		return null;
	}

}
