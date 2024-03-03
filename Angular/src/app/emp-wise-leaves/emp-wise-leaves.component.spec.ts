import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpWiseLeavesComponent } from './emp-wise-leaves.component';

describe('EmpWiseLeavesComponent', () => {
  let component: EmpWiseLeavesComponent;
  let fixture: ComponentFixture<EmpWiseLeavesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmpWiseLeavesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmpWiseLeavesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
