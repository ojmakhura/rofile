import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RofileLayoutComponent } from './rofile-layout.component';

describe('RofileLayoutComponent', () => {
  let component: RofileLayoutComponent;
  let fixture: ComponentFixture<RofileLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RofileLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RofileLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
