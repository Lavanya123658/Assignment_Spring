import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayleaveComponent } from './displayleave.component';

describe('DisplayleaveComponent', () => {
  let component: DisplayleaveComponent;
  let fixture: ComponentFixture<DisplayleaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayleaveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplayleaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
