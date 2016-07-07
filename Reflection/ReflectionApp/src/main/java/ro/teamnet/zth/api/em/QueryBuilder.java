package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Eduard on 07.07.2016.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private List<Condition> conditions;
    private QueryType queryType;


    public String getValueForQuery(Object value){
        if(value.getClass().equals(String.class)){
            return "'"+value+"'" ;
        }
        else{

            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";

        }

    }

    public QueryBuilder addCondition(Condition condition){
        QueryBuilder queryBuilder = new QueryBuilder();
        if(conditions != null)   conditions.add(condition);
        else {
            conditions = new ArrayList<Condition>();
            conditions.add(condition);
        }
        return this;

    }

    public QueryBuilder setTableName(Object tableName){
        this.tableName = tableName;
        return this;
    }
    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns){
        if(this.queryColumns != null){
           this.queryColumns.addAll(queryColumns);
        }else{
            this.queryColumns = new ArrayList<ColumnInfo>();
            this.queryColumns.addAll(queryColumns);
        }
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
        return this;
    }


    private StringBuilder createSelectQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        for(ColumnInfo q:queryColumns){
            sb.append(q);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length());
        sb.append(" FROM "+ tableName+";");
        return sb;
    }

    private StringBuilder createDeleteQuery(ColumnInfo columnInfo){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM "+tableName+" WHERE "+columnInfo.getColumnName()
        " = "+columnInfo.getValue());
        return sb;
    }

    private boolean createUpdatetQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");

        return false;
    }

}
