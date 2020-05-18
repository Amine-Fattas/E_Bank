import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteCourantComponent } from './compte-courant.component';

describe('CompteCourantComponent', () => {
  let component: CompteCourantComponent;
  let fixture: ComponentFixture<CompteCourantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteCourantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteCourantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
