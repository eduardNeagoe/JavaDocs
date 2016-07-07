package ro.teamnet.zth.api.em;

import javafx.beans.binding.IntegerExpression;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eduard on 07.07.2016.
 */
public class EntityUtils {
    private EntityUtils(){
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity){
        Table tab = (Table) entity.getDeclaredAnnotation(Table.class);
        return tab.name();
    }
    public static List<ColumnInfo> getColumns(Class entity){
        List<ColumnInfo> colList = new ArrayList<ColumnInfo>();
//        return colList;
        Field[] fields = entity.getDeclaredFields();
        for(Field f:fields){
            ColumnInfo col = new ColumnInfo();
            col.setColumnName(f.getName());
            col.setColumnType(f.getType());

            Column column = (Column)f.getAnnotation(Column.class);
            if(column != null){
                col.setDbName(column.name());
                col.setId(false);
            }else{
                Id id = (Id) f.getAnnotation(Id.class);
                if(id != null){
                    col.setDbName(id.name());
                    col.setId(true);
                }
            }
            colList.add(col);
        }
        return colList;

    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value.getClass() == BigDecimal.class && wantedType.getClass().equals(Integer.class)){
            return (Integer) value;
        }
        if(value.getClass() == BigDecimal.class && wantedType.getClass().equals(Long.class)){
            return (Long) value;
        }
        if(value.getClass() == BigDecimal.class && wantedType.getClass().equals(Float.class)){
            return (Float) value;
        }
        if(value.getClass() == BigDecimal.class && wantedType.getClass().equals(Double.class)){
            return (Double) value;
        }
        return value;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        List<Field> fieldList = new ArrayList<Field>();
        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            if(f.getAnnotation(annotation) != null){
                fieldList.add(f);
            }
            }
        return fieldList;
    }


    public static Object getSqlValue(Object obj){
        if(obj.getClass().getAnnotation(Table.class) != null){
//            List<Field> fieldList = new ArrayList<>();
            Field[] fields = obj.getClass().getDeclaredFields();
            for(Field f:fields){
                if(f.getAnnotation(Id.class) != null){
                    f.setAccessible(true);
                    return obj;
                }
            }
        }
        return obj;
    }
}


