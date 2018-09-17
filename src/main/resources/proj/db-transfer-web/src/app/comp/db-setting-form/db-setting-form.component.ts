import {Component, Inject, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {DbSetting} from "../../entity/db-setting";

@Component({
  selector: 'app-db-setting-form',
  templateUrl: './db-setting-form.component.html',
  styleUrls: ['./db-setting-form.component.css']
})
export class DbSettingFormComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<DbSettingFormComponent>,
               @Inject(MAT_DIALOG_DATA) public data: DbSetting) { }
 dbTypes=[{
    name:'SQLServer',
   value:0
 }]
  ngOnInit() {
  }
  submit(){
    this.dialogRef.close(this.data)
  }
}
