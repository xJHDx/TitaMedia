import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogicoComponent } from './logico.component';

describe('LogicoComponent', () => {
  let component: LogicoComponent;
  let fixture: ComponentFixture<LogicoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogicoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
