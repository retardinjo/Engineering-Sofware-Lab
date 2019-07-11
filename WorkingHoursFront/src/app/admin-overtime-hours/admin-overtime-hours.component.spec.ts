import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOvertimeHoursComponent } from './admin-overtime-hours.component';

describe('AdminOvertimeHoursComponent', () => {
  let component: AdminOvertimeHoursComponent;
  let fixture: ComponentFixture<AdminOvertimeHoursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminOvertimeHoursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOvertimeHoursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
