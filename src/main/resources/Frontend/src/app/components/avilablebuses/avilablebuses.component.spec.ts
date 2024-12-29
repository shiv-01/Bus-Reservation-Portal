import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvilablebusesComponent } from './avilablebuses.component';

describe('AvilablebusesComponent', () => {
  let component: AvilablebusesComponent;
  let fixture: ComponentFixture<AvilablebusesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvilablebusesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvilablebusesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
