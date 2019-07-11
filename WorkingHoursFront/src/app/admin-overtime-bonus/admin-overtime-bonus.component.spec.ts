import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOvertimeBonusComponent } from './admin-overtime-bonus.component';

describe('AdminOvertimeBonusComponent', () => {
  let component: AdminOvertimeBonusComponent;
  let fixture: ComponentFixture<AdminOvertimeBonusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminOvertimeBonusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOvertimeBonusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
