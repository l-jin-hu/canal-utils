package com.github.wz2cool.canal.utils.model;

import java.util.Optional;

public enum MysqlDataType {
    BIT("BIT"),
    TINYINT("TINYINT"),
    SMALLINT("SMALLINT"),
    MEDIUMINT("MEDIUMINT"),
    INT("INT"),
    INTEGER("INTEGER"),
    BIGINT("BIGINT"),
    FLOAT("FLOAT"),
    DOUBLE("DOUBLE"),
    DECIMAL("DECIMAL"),
    DATE("DATE"),
    DATETIME("DATETIME"),
    TIMESTAMP("TIMESTAMP"),
    TIME("TIME"),
    CHAR("CHAR"),
    VARCHAR("VARCHAR"),
    TINYBLOB("TINYBLOB"),
    BLOB("BLOB"),
    MEDIUMBLOB("MEDIUMBLOB"),
    LONGBLOB("LONGBLOB"),
    TINYTEXT("TINYTEXT"),
    TEXT("TEXT"),
    MEDIUMTEXT("MEDIUMTEXT"),
    LONGTEXT("LONGTEXT"),
    JSON("JSON");

   /* ENUM("ENUM"),
    REAL("REAL"),
    SET("SET"),
    YEAR("YEAR"),
    NUMERIC("NUMERIC"),
    BINARY("BINARY"),
    VARBINARY("VARBINARY")*/

    private String text;

    MysqlDataType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Optional<MysqlDataType> getDataType(String typeString) {
        try {
            String[] mysqlTypeMetadatas = typeString.split("\\(");
            if (mysqlTypeMetadatas.length == 0) {
                return Optional.empty();
            }
            String mysqlTypeStr = mysqlTypeMetadatas[0].toUpperCase()
                    .replace("UNSIGNED", "")
                    .replace("NUMERIC", "DECIMAL")
                    .trim();
            MysqlDataType mysqlDataType = MysqlDataType.valueOf(mysqlTypeStr);
            return Optional.of(mysqlDataType);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}