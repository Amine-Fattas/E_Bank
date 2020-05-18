import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NemuBarComponent } from './nemu-bar.component';

describe('NemuBarComponent', () => {
  let component: NemuBarComponent;
  let fixture: ComponentFixture<NemuBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NemuBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NemuBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
