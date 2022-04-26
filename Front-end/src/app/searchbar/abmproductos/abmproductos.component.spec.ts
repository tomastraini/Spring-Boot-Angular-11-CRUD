import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmproductosComponent } from './abmproductos.component';

describe('AbmproductosComponent', () => {
  let component: AbmproductosComponent;
  let fixture: ComponentFixture<AbmproductosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AbmproductosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmproductosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
