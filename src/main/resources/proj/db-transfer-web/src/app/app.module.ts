import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DbSettingComponent } from './comp/db-setting/db-setting.component';
import { DbTransferComponent } from './comp/db-transfer/db-transfer.component';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {GlobalProgressService}from './service/global-progress.service';
import { DbSettingService }from './service/db-setting.service';
import { DbTransferService }from './service/db-transfer.service';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { RouterModule, Routes } from '@angular/router';
import { InfoComponent } from './comp/info/info.component';
import { DbSettingFormComponent } from './comp/db-setting-form/db-setting-form.component';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatTableModule} from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule }   from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatSelectModule} from '@angular/material/select';

const appRoutes: Routes = [
  { path: 'db/setting', component: DbSettingComponent },
  { path: 'db/transfer',      component: DbTransferComponent },
  { path: '**', component: InfoComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    DbSettingComponent,
    DbTransferComponent,
    InfoComponent,
    DbSettingFormComponent
  ],
  imports: [
    BrowserModule,
    MatProgressBarModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    MatTableModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    MatSnackBarModule,
    MatSelectModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [GlobalProgressService,DbSettingService,DbTransferService],
  bootstrap: [AppComponent],
  entryComponents:[
    DbSettingFormComponent
  ]
})
export class AppModule { }
