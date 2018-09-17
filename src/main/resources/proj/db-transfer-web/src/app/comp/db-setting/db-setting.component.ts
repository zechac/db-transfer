import { Component, OnInit } from '@angular/core';
import {DbSettingService}from '../../service/db-setting.service'
import {DbSettingFormComponent} from "../db-setting-form/db-setting-form.component";
import {MatDialog, MatSnackBar} from "@angular/material";
import {DbSetting} from "../../entity/db-setting";

@Component({
  selector: 'app-db-setting',
  templateUrl: './db-setting.component.html',
  styleUrls: ['./db-setting.component.css']
})
export class DbSettingComponent implements OnInit {

  constructor(private dbSettingService:DbSettingService,
              public dialog: MatDialog,
              public snackBar: MatSnackBar) { }

  displayedColumns=["c1","c2","c3","c4","c5"]
  dataSource=[]
  edit(id){
    this.dbSettingService.get(id).subscribe(r=>{
      this.openDialog(r.data)
    })
  }
  openDialog(data){
    const dialogRef = this.dialog.open(DbSettingFormComponent, {
      width: '400px',
      data: data
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if(result.name){
        this.dbSettingService.save(result as DbSetting).subscribe(r=>{
          this.findAll();
          this.snackBar.open("成功","", {
            duration: 2000,
          });
        })
      }
    });
  }

  add(){
   this.openDialog({})
  }

  findAll(){
    this.dbSettingService.findAll().subscribe(r=>{
      this.dataSource=r.data
    })
  }

  ngOnInit() {
      this.findAll()
  }

}
