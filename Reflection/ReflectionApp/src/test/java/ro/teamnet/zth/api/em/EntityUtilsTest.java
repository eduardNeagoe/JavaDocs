package ro.teamnet.zth.api.em;

import org.junit.Test;
import org.w3c.dom.Entity;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Eduard on 07.07.2016.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod(){
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumnsMethod(){

        List<ColumnInfo> listObtained = EntityUtils.getColumns(Department.class);
        assertEquals(listObtained.size(),3);
        System.out.println(listObtained);
    }

//    @Test public void testCastFromSqlType(, Integer.class){
//
//    }

    @Test
    public void testCastFromSqlType(){
        Object obj = new Double(1231321);
        Object objReturn = EntityUtils.castFromSqlType(obj, Double.class);
        assertEquals("Eroare cast: ", Double.class, objReturn.getClass());
    }
    @Test
    public void testGetFieldsByAnnotations(){
//        List<Field> fields = new ArrayList<Field>();
        List<Field> fieldReturned = EntityUtils.getFieldsByAnnotations(Department.class, Column.class);
        assertEquals("Eroare la size!", 2, fieldReturned.size());

    }

    @Test
    public void testSetSqlValue(){
        Object obj = new Location();

        Object objReturned = EntityUtils.getSqlValue(obj);

        assertEquals("Eroare id setat Accessible",  obj, objReturned);
    }
}
