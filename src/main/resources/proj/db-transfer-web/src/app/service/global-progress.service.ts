import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalProgressService {

  constructor() { }

  //indeterminate
  status:string

  INDETERMINATE="indeterminate"
}
