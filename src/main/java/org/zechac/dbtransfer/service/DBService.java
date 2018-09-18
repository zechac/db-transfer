package org.zechac.dbtransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zechac.dbtransfer.domain.DBSetting;
import org.zechac.dbtransfer.repo.DBSettingRepo;
import org.zechac.dbtransfer.utils.DBUtils;
import org.zechac.dbtransfer.utils.ResponseData;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DBService {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private DBSettingRepo dbSettingRepo;

    @Autowired
    private TransferMappingService transferMappingService;

    public void save(DBSetting dbSetting) {
        dbSettingRepo.save(dbSetting);
    }

    public List findAll() {
        return dbSettingRepo.findAll();
    }

    public void deleteById(int id) {
        dbSettingRepo.deleteById(id);
    }

    public DBSetting getById(int id){return dbSettingRepo.findById(id).get();}

    public String getDbName(String connstr){
        int x=connstr.lastIndexOf("DatabaseName=");
        return connstr.substring(x+13,connstr.length());
    }

    public Map tables(DBSetting dbSetting) {
        List<String> tables=new ArrayList<String>();
        try{
            Connection connection=getConnection(dbSetting);
            switch (dbSetting.getDbType()){
                case ORACLE:
                    break;
                case MYSQL:
                    break;
                case SQLSERVER:
                     String dbName=getDbName(dbSetting.getConnStr());
                     connection.createStatement().execute("use "+dbName);
                     ResultSet resultSet= connection.createStatement().executeQuery("select name from sysobjects where xtype='u'");
                     tables= DBUtils.resultSetToList(resultSet,String.class);
                    break;
            }
            connection.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return ResponseData.Success().putData(tables);
    }

    public Connection getConnection(DBSetting db) throws SQLException {
        switch (db.getDbType()){
            case MYSQL:
                break;
            case SQLSERVER:
                return DriverManager.getConnection(db.getConnStr(),db.getUsername(),db.getPassword());
            case ORACLE:
                break;
        }
        return null;
    }

    public Map fields(DBSetting dbSetting, String table) {
        List<String> tables=new ArrayList<String>();
        try{
            Connection connection=getConnection(dbSetting);
            switch (dbSetting.getDbType()){
                case ORACLE:
                    break;
                case MYSQL:
                    break;
                case SQLSERVER:
                    ResultSet resultSet= connection.createStatement().executeQuery(String.format("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='%s'",table));
                    tables= DBUtils.resultSetToList(resultSet,String.class);
                    break;
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ResponseData.Success().putData(tables);
    }
}
