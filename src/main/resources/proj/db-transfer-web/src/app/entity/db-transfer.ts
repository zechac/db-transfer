import {DbSetting} from "./db-setting";

export class DbTransfer {
  id:string
  name:string
  fromDB:DbSetting
  toDB:DbSetting
  fromTable:string
  toTable:string
  data:string
}
