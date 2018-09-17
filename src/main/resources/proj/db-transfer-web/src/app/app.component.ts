import { Component } from '@angular/core';
import {GlobalProgressService}from './service/global-progress.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'db-transfer-web';

  constructor(public globlaProgress:GlobalProgressService) {

  }
}
