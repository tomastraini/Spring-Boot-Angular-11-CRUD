import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmprovinciasComponent } from './abmprovincias.component';

describe('AbmprovinciasComponent', () => {
  let component: AbmprovinciasComponent;
  let fixture: ComponentFixture<AbmprovinciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AbmprovinciasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmprovinciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
