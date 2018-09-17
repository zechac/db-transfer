import { TestBed } from '@angular/core/testing';

import { GlobalProgressService } from './global-progress.service';

describe('GlobalProgressService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GlobalProgressService = TestBed.get(GlobalProgressService);
    expect(service).toBeTruthy();
  });
});
