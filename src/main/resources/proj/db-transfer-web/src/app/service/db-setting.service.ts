import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import {ResponseData} from "../entity/response-data";
import {DbSetting} from "../entity/db-setting";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class DbSettingService {

  constructor(private httpService:HttpClient) { }


  findAll():Observable<ResponseData>{
    return this.httpService.get<ResponseData>("api/db/setting/list")
  }

  save(dbSetting:DbSetting):Observable<ResponseData>{
    return this.httpService.post<ResponseData>("api/db/setting/save",dbSetting,httpOptions)
  }

  get(id:string){
    return this.httpService.get<ResponseData>("api/db/setting/get/"+id)
  }

  loadTables(db:DbSetting):Observable<ResponseData>{
    return this.httpService.post<ResponseData>("api/db/setting/tables",db)
  }

}
