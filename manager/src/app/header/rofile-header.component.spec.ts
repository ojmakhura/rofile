import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RofileHeaderComponent } from './rofile-header.component';

describe('RofileHeaderComponent', () => {
  let component: RofileHeaderComponent;
  let fixture: ComponentFixture<RofileHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RofileHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RofileHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
