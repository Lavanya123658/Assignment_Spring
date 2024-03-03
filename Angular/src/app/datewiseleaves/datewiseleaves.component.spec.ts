import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatewiseleavesComponent } from './datewiseleaves.component';

describe('DatewiseleavesComponent', () => {
  let component: DatewiseleavesComponent;
  let fixture: ComponentFixture<DatewiseleavesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DatewiseleavesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatewiseleavesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
