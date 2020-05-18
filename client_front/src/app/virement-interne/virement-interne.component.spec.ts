import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VirementInterneComponent } from './virement-interne.component';

describe('VirementInterneComponent', () => {
  let component: VirementInterneComponent;
  let fixture: ComponentFixture<VirementInterneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VirementInterneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VirementInterneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
