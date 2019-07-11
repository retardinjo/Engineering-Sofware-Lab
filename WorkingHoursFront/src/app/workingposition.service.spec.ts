import { TestBed } from '@angular/core/testing';

import { WorkingpositionService } from './workingposition.service';

describe('WorkingpositionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WorkingpositionService = TestBed.get(WorkingpositionService);
    expect(service).toBeTruthy();
  });
});
