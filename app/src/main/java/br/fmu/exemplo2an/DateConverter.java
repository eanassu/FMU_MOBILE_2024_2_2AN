package br.fmu.exemplo2an;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null?null:new Date(timestamp);
    }

    public static Long toTimeStamp(Date date) {
        return date == null?null: date.getTime();
    }
}
