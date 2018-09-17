import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbTransferComponent } from './db-transfer.component';

describe('DbTransferComponent', () => {
  let component: DbTransferComponent;
  let fixture: ComponentFixture<DbTransferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbTransferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbTransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
