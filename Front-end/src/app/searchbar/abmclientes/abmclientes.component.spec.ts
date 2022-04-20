import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmclientesComponent } from './abmclientes.component';

describe('AbmclientesComponent', () => {
  let component: AbmclientesComponent;
  let fixture: ComponentFixture<AbmclientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AbmclientesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmclientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
