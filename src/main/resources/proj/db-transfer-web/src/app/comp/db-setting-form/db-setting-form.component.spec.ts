import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbSettingFormComponent } from './db-setting-form.component';

describe('DbSettingFormComponent', () => {
  let component: DbSettingFormComponent;
  let fixture: ComponentFixture<DbSettingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbSettingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbSettingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
