import { Injectable } from '@angular/core';
import {DbTransfer} from "../entity/db-transfer";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ResponseData} from "../entity/response-data";

@Injectable({
  providedIn: 'root'
})
export class DbTransferService {

  constructor(private httpService:HttpClient) { }

  doTransfer(dbTransfer:DbTransfer):Observable<ResponseData>{
    return this.httpService.post<ResponseData>("api/db/transfer/mapping/transfer",dbTransfer)
  }
}
