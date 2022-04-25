import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmproveedoresComponent } from './abmproveedores.component';

describe('AbmproveedoresComponent', () => {
  let component: AbmproveedoresComponent;
  let fixture: ComponentFixture<AbmproveedoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AbmproveedoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmproveedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
