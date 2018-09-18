package org.zechac.dbtransfer.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    @SuppressWarnings("unchecked")
    public static <T> List<T> resultSetToList(ResultSet resultSet,Class<T> clazz) throws SQLException {
        List<T> list=new ArrayList();
        while (resultSet.next()){
            if(String.class.isAssignableFrom(clazz)){
                list.add((T)resultSet.getString(1));
            }else if (Map.class.isAssignableFrom(clazz)){
                Map map=new HashMap();
               int columnCount= resultSet.getMetaData().getColumnCount();
               for(int i=0;i<columnCount;i++){
                   String label=resultSet.getMetaData().getColumnLabel(i+1);
                   Object val=resultSet.getObject(i+1);
                   map.put(label,val);
                   list.add((T)map);
               }
            }
        }
        return list;
    }
}
