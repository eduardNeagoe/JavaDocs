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



    private String getValueForQuery(Object value) {
        if (value == null){
            return null;
        }
        if (value instanceof String){
            return "'" + value + "'";
        } else if (value instanceof java.sql.Date){
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            return "STR_TO_DATE('" + dateFormat.format((Date) value) + "', '%m/%d/%Y')";
        } else {
            return value.toString();
        }
    }

    public QueryBuilder addCondition(Condition condition) {
        if (this.conditions == null){
            this.conditions = new ArrayList<>();
        }
        this.conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName){
        this.tableName = tableName;
        return this;
    }
    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        if (this.queryColumns == null){
            this.queryColumns = new ArrayList<>();
        }
        this.queryColumns.addAll(queryColumns);
        return this;
    }


    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
        return this;
    }



    private String createSelectQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append("select ");
        boolean isFirst = true;
        for(ColumnInfo columnInfo : queryColumns) {
            if(!isFirst) {
                sql.append(",");
            }
            sql.append(tableName + "." + columnInfo.getDbName());
            isFirst = false;
        }
        sql.append(" from " + tableName);

        boolean whereAdded = false;
        if(conditions != null && !conditions.isEmpty()) {
            for(Condition condition : conditions) {
                sql.append(whereAdded ? " and" : " where ").append(condition.getColumnName()).append("=")
                        .append(getValueForQuery(condition.getValue()));
                whereAdded = true;
            }
        }
        return sql.toString();
    }
    private String createDeleteQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append("delete from ").append(tableName);
        boolean whereAdded = false;
        if (conditions != null  && !conditions.isEmpty()){
            for (Condition condition : conditions) {
                sql.append(whereAdded ? " and" : " where ").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                whereAdded = true;
            }
        }
        return sql.toString();
    }

    private String createUpdateQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append("update ").append(tableName).append(" set ");
        boolean first = true;
        for (ColumnInfo column : queryColumns) {
            if (!column.isId()) {
                if (!first) {
                    sql.append(",");
                } else {
                    first = false;
                }
                sql.append(column.getDbName()).append("=").append(getValueForQuery(column.getValue()));
            }
        }

        boolean whereAdded = false;
        if (conditions != null  && !conditions.isEmpty()){
            for (Condition condition : conditions) {
                sql.append(whereAdded ? " and" : " where ").append(condition.getColumnName()).append("=").append(getValueForQuery(condition.getValue()));
                whereAdded = true;
            }
        }
        return sql.toString();
    }

    private String createInsertQuery() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append(" (");
        StringBuilder sqlValues = new StringBuilder(" values (");
        boolean first = true;
        for (ColumnInfo columnInfo : queryColumns) {
            if (columnInfo.isId()) {
                continue;
            }
            if (!first) {
                sql.append(",");
                sqlValues.append(",");
            } else {
                first = false;
            }
            sql.append(columnInfo.getDbName());
            sqlValues.append(getValueForQuery(columnInfo.getValue()));
        }

        sql.append(") ");
        sqlValues.append(")");
        sql.append(sqlValues);

        return sql.toString();
    }

    public String createQuery() {
        if (QueryType.SELECT.equals(this.queryType)){
            return createSelectQuery();
        } else if (QueryType.INSERT.equals(this.queryType)) {
            return createInsertQuery();
        } else if (QueryType.UPDATE.equals(this.queryType)) {
            return createUpdateQuery();
        } else if (QueryType.DELETE.equals(this.queryType)) {
            return createDeleteQuery();
        }
        return null;
    }



}
