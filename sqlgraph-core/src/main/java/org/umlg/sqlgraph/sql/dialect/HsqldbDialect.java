package org.umlg.sqlgraph.sql.dialect;

import com.tinkerpop.gremlin.structure.Property;
import org.umlg.sqlgraph.structure.PropertyType;

import java.sql.Types;

/**
 * Date: 2014/07/16
 * Time: 3:09 PM
 */
public class HsqldbDialect implements SqlDialect {

    @Override
    public void validateProperty(Object key, Object value) {
        if (value instanceof String) {
            return;
        }
        if (value instanceof Character) {
            return;
        }
        if (value instanceof Boolean) {
            return;
        }
        if (value instanceof Byte) {
            return;
        }
        if (value instanceof Short) {
            return;
        }
        if (value instanceof Integer) {
            return;
        }
        if (value instanceof Long) {
            return;
        }
        if (value instanceof Float) {
            return;
        }
        if (value instanceof Double) {
            return;
        }
        throw Property.Exceptions.dataTypeOfPropertyValueNotSupported(value);
    }

    @Override
    public String getColumnEscapeKey() {
        return "\"";
    }

    @Override
    public String getPrimaryKeyType() {
        return "BIGINT NOT NULL";
    }

    @Override
    public String getAutoIncrementPrimaryKeyConstruct() {
        return "GENERATED BY DEFAULT AS IDENTITY";
    }

    @Override
    public String propertyTypeToSqlDefinition(PropertyType propertyType) {

        switch (propertyType) {
            case BOOLEAN:
                return "BOOLEAN" ;
            case BYTE:
                return "TINYINT" ;
            case SHORT:
                return "TINYINT" ;
            case INTEGER:
                return "INTEGER" ;
            case LONG:
                return "BIGINT" ;
            case FLOAT:
                return "REAL" ;
            case DOUBLE:
                return "DOUBLE" ;
            case STRING:
                return "LONGVARCHAR";
            default:
                throw new IllegalStateException("Unknown propertyType " + propertyType.name());
        }
    }

    @Override
    public int propertyTypeToJavaSqlType(PropertyType propertyType) {
        switch (propertyType) {
            case BOOLEAN:
                return Types.BOOLEAN ;
            case BYTE:
                return Types.TINYINT;
            case SHORT:
                return Types.TINYINT;
            case INTEGER:
                return Types.INTEGER;
            case LONG:
                return Types.BIGINT;
            case FLOAT:
                return Types.REAL;
            case DOUBLE:
                return Types.BOOLEAN;
            case STRING:
                return Types.CLOB;
            default:
                throw new IllegalStateException("Unknown propertyType " + propertyType.name());
        }
    }

    @Override
    public String getForeignKeyTypeDefinition() {
        return "BIGINT NOT NULL";
    }

    @Override
    public boolean supportsFloatValues() {
        return false;
    }

}
