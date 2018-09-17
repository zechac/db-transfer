package org.zechac.dbtransfer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zechac.dbtransfer.domain.TransferData;
import org.zechac.dbtransfer.domain.TransferItem;
import org.zechac.dbtransfer.domain.TransferMapping;
import org.zechac.dbtransfer.repo.TransferMappingRepo;
import org.zechac.dbtransfer.utils.DBUtils;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TransferMappingService {
    @Autowired
    private TransferMappingRepo transferMappingRepo;
    @Autowired
    private DBService dbService;

    public void save(TransferMapping transferMapping) {
        transferMappingRepo.save((transferMapping));
    }

    public List findAll() {
        return transferMappingRepo.findAll();
    }

    public void deleteById(int id) {
        transferMappingRepo.deleteById(id);
    }

    public Map transfer(TransferMapping transferMapping) {
        try {
            Connection connection1=dbService.getConnection(transferMapping.getFromDB());
            Connection connection2=dbService.getConnection(transferMapping.getToDB());
            ObjectMapper objectMapper=new ObjectMapper();
            TransferData transferData= objectMapper.readValue(transferMapping.getData(), TransferData.class);
            String sql1=buildReadSql(transferMapping,transferData);
            String sql2=buildWriteSql(transferMapping,transferData);
            ResultSet resultSet=connection1.createStatement().executeQuery(sql1);
            List<Map<String,String>> source= (List)DBUtils.resultSetToList(resultSet,Map.class);
            for(Map<String,String> map :source){
                String sql="";
               for(Map.Entry<String,String> entry: map.entrySet()){
                   sql2.replace("#"+entry.getKey(),entry.getValue());
               }
               connection2.createStatement().executeUpdate(sql);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return null;

    }

    private String buildWriteSql(TransferMapping transferMapping, TransferData transferData) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("insert into (");
        for(TransferItem transferItem : transferData.getMappingFields()){
            stringBuilder.append(transferItem.getTo()+",");
        }
        stringBuilder.delete(stringBuilder.length()-1,1);
        stringBuilder.append(") values( ");
        for(TransferItem transferItem : transferData.getMappingFields()){
            stringBuilder.append("#"+transferItem.getFrom()+",");
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private String buildReadSql(TransferMapping transferMapping, TransferData transferData) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("select ");
        for(TransferItem transferItem : transferData.getMappingFields()){
            stringBuilder.append(transferItem.getFrom()+",");
        }
        stringBuilder.delete(stringBuilder.length()-1,1);
        stringBuilder.append(" from ");
        stringBuilder.append(transferMapping.getFromTable());
        return stringBuilder.toString();
    }


}
