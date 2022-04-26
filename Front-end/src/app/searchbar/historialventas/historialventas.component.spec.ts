import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorialventasComponent } from './historialventas.component';

describe('HistorialventasComponent', () => {
  let component: HistorialventasComponent;
  let fixture: ComponentFixture<HistorialventasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorialventasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorialventasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
