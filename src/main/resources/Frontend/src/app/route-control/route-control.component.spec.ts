import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RouteControlComponent } from './route-control.component';

describe('RouteControlComponent', () => {
  let component: RouteControlComponent;
  let fixture: ComponentFixture<RouteControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RouteControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RouteControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
