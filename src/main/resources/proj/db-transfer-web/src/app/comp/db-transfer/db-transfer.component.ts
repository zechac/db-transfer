import { Component, OnInit } from '@angular/core';
import {DbTransfer} from "../../entity/db-transfer";
import {DbSettingService} from "../../service/db-setting.service";
import {TransferData} from "../../entity/transfer-data";
import {TransferItem} from "../../entity/transfer-item";
import {DbTransferService} from "../../service/db-transfer.service";
import {MatSnackBar} from "@angular/material";
import {GlobalProgressService} from "../../service/global-progress.service";

@Component({
  selector: 'app-db-transfer',
  templateUrl: './db-transfer.component.html',
  styleUrls: ['./db-transfer.component.css']
})
export class DbTransferComponent implements OnInit {

  constructor(public dbService:DbSettingService,
              public dbTransferService:DbTransferService,
              public snackBar: MatSnackBar,
              public globlaProgress:GlobalProgressService) { }

  fieldData=new TransferData()
  db1=[]
  db2=[]
  tab1=[]
  tab2=[]


  dbTransfer=new DbTransfer()

  ngOnInit() {
    this.dbService.findAll().subscribe(r=>{
      this.db1=r.data
    })
    this.dbService.findAll().subscribe(r=>{
      this.db2=r.data
    })
  }

  db1Change(v){
    this.dbService.loadTables(v).subscribe(r=>{
      this.tab1=r.data
    })
  }
  db2Change(v){
    this.dbService.loadTables(v).subscribe(r=>{
      this.tab2=r.data
    })
  }

  addField(){
    var item=new TransferItem()
    this.fieldData.mappingFields.push(item)
  }
  transfer(){
    this.globlaProgress.status=this.globlaProgress.INDETERMINATE
    this.dbTransfer.data= JSON.stringify(this.fieldData)
    this.dbTransferService.doTransfer(this.dbTransfer).subscribe(r=>{
      this.globlaProgress.status=""
      this.snackBar.open("成功","", {
        duration: 2000,
      });
    })
  }
}
