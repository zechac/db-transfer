import { TestBed } from '@angular/core/testing';

import { DbTransferService } from './db-transfer.service';

describe('DbTransferService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DbTransferService = TestBed.get(DbTransferService);
    expect(service).toBeTruthy();
  });
});
