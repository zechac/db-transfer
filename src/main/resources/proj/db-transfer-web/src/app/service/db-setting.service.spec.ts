import { TestBed } from '@angular/core/testing';

import { DbSettingService } from './db-setting.service';

describe('DbSettingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DbSettingService = TestBed.get(DbSettingService);
    expect(service).toBeTruthy();
  });
});
