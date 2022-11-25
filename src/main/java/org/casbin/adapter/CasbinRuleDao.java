package org.casbin.adapter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CasbinRuleDao {
    @Select("select * from casbin_rule")
    List<CasbinRule> loadAll();

    @Update("CREATE DATABASE IF NOT EXISTS ${databaseName}")
    void createMysqlDatabase(@Param("databaseName") String databaseName);

    @Update("IF NOT EXISTS (" +
            "SELECT * FROM sysdatabases WHERE name = 'casbin') CREATE DATABASE casbin ON PRIMARY " +
            "( NAME = N'casbin', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL.1\\MSSQL\\DATA\\casbinDB.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB ) " +
            "LOG ON\n" +
            "( NAME = N'casbin_log', FILENAME = N'C:\\Program Files\\Microsoft SQL Server\\MSSQL.1\\MSSQL\\DATA\\casbinDB_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%) " +
            "COLLATE Chinese_PRC_CI_AS")
    void createSqlServerDatabase(@Param("databaseName") String databaseName);

    @Update("CREATE TABLE IF NOT EXISTS ${tableName} " +
            "(ptype VARCHAR(100) not NULL, " +
            " v0 VARCHAR(100), " +
            " v1 VARCHAR(100), " +
            " v2 VARCHAR(100), " +
            " v3 VARCHAR(100), " +
            " v4 VARCHAR(100), " +
            " v5 VARCHAR(100))")
    void createMysqlTable(@Param("tableName") String tableName);

    @Update("if not exists (select * from sysobjects where id = object_id('${tableName}')) " +
            "create table ${tableName} (" +
            "   ptype VARCHAR(100) not NULL, " +
            "   v0 VARCHAR(100), " +
            "   v1 VARCHAR(100), " +
            "   v2 VARCHAR(100), " +
            "   v3 VARCHAR(100), " +
            "   v4 VARCHAR(100), " +
            "   v5 VARCHAR(100) " +
            ")")
    void createSqlServerTable(@Param("tableName") String tableName);

    @Update("declare " +
            "nCount NUMBER;" +
            "v_sql LONG;" +
            "begin " +
            "SELECT count(*) into nCount FROM USER_TABLES where table_name = '${tableName}';" +
            "IF(nCount <= 0) " +
            "THEN " +
            "v_sql:='" +
            "CREATE TABLE ${tableName} " +
            "                    (ptype VARCHAR(100) not NULL, " +
            "                     v0 VARCHAR(100), " +
            "                     v1 VARCHAR(100), " +
            "                     v2 VARCHAR(100), " +
            "                     v3 VARCHAR(100)," +
            "                     v4 VARCHAR(100)," +
            "                     v5 VARCHAR(100))';" +
            "execute immediate v_sql;" +
            "END IF;" +
            "end;")
    void createOracleTable(@Param("tableName") String tableName);

    @Update("DROP TABLE IF EXISTS ${tableName}")
    void dropMysqlTable(@Param("tableName") String tableName);

    @Update("declare " +
            "nCount NUMBER;" +
            "v_sql LONG;" +
            "begin " +
            "SELECT count(*) into nCount FROM dba_tables where table_name = '${tableName}';" +
            "IF(nCount >= 1) " +
            "THEN " +
            "v_sql:='drop table ${tableName}';" +
            "execute immediate v_sql;" +
            "END IF;" +
            "end;")
    void dropOracleTable(@Param("tableName") String tableName);

    @Update("if exists (select * from sysobjects where id = object_id('${tableName}') drop table ${tableName}")
    void dropSqlServerTable(@Param("tableName") String tableName);

    @Insert("INSERT INTO casbin_rule (ptype,v0,v1,v2,v3,v4,v5) VALUES (#{ptype},#{v0},#{v1},#{v2},#{v3},#{v4},#{v5})")
    void insertData(CasbinRule line);

    @Insert({"<script>",
            "INSERT INTO casbin_rule (ptype, v0, v1, v2, v3, v4, v5) VALUES ",
            "<foreach collection='list' item='item' separator=','>",
            "(#{item.ptype}, #{item.v0}, #{item.v1}, #{item.v2}, #{item.v3}, #{item.v4}, #{item.v5})",
            "</foreach>",
            "</script>"
    })
    void insertDataBatch(@Param("list") List<CasbinRule> rules);

    @Insert("<script>"  +
            "DELETE FROM casbin_rule WHERE ptype = #{ptype}" +
            "<foreach collection=\"list\" item=\"item1\" index=\"index\"  separator=\" \">" +
            " AND v#{index} = #{item1}" +
            "</foreach>" +
            "</script>")
    void deleteData(@Param("ptype") String ptype, @Param("list") List<String> rules);
}
