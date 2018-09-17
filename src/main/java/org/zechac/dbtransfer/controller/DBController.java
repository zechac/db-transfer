package org.zechac.dbtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zechac.dbtransfer.domain.DBSetting;
import org.zechac.dbtransfer.service.DBService;
import org.zechac.dbtransfer.utils.ResponseData;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("db")
public class DBController {

    @Autowired
    private DBService dbService;

    @RequestMapping("save")
    public Map save(@RequestBody DBSetting dbSetting){
        dbService.save(dbSetting);
        return ResponseData.Success();
    }

    @RequestMapping("list")
    public Map list(){
        List list=dbService.findAll();
        return ResponseData.Success().putData(list);
    }

    @RequestMapping("delete")
    public Map delete(int id){
        dbService.deleteById(id);
        return ResponseData.Success();
    }

    @RequestMapping("tables")
    public Map getTables(@RequestBody DBSetting dbSetting){
        return dbService.tables(dbSetting);
    }

    @RequestMapping("fields/{table}")
    public Map getTables(@RequestBody DBSetting dbSetting, @PathVariable String table){
        return dbService.fields(dbSetting,table);
    }
}
