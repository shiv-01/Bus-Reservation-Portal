import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackControlComponent } from './feedback-control.component';

describe('FeedbackControlComponent', () => {
  let component: FeedbackControlComponent;
  let fixture: ComponentFixture<FeedbackControlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackControlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
