package org.zechac.dbtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zechac.dbtransfer.domain.DBSetting;
import org.zechac.dbtransfer.domain.TransferMapping;
import org.zechac.dbtransfer.service.DBService;
import org.zechac.dbtransfer.service.TransferMappingService;
import org.zechac.dbtransfer.utils.ResponseData;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transfer/mapping")
public class TransferMappingController {
    @Autowired
    private TransferMappingService transferMappingService;

    @RequestMapping("save")
    public Map save(@RequestBody TransferMapping transferMapping){
        transferMappingService.save(transferMapping);
        return ResponseData.Success();
    }

    @RequestMapping("list")
    public Map list(){
        List list=transferMappingService.findAll();
        return ResponseData.Success().putData(list);
    }

    @RequestMapping("delete")
    public Map delete(int id){
        transferMappingService.deleteById(id);
        return ResponseData.Success();
    }

    @RequestMapping("transfer")
    public Map doTransfer(@RequestBody TransferMapping transferMapping){
        return transferMappingService.transfer(transferMapping);
    }

}
