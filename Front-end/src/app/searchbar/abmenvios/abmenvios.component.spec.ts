import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmenviosComponent } from './abmenvios.component';

describe('AbmenviosComponent', () => {
  let component: AbmenviosComponent;
  let fixture: ComponentFixture<AbmenviosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AbmenviosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmenviosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
