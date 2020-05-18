import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteDesactiveComponent } from './compte-desactive.component';

describe('CompteDesactiveComponent', () => {
  let component: CompteDesactiveComponent;
  let fixture: ComponentFixture<CompteDesactiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteDesactiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteDesactiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
