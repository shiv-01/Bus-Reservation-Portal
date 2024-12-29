import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusControlComponent } from './bus-control.component';

describe('BusControlComponent', () => {
  let component: BusControlComponent;
  let fixture: ComponentFixture<BusControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BusControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
