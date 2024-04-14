import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransacitonsComponent } from './transacitons.component';

describe('TransacitonsComponent', () => {
  let component: TransacitonsComponent;
  let fixture: ComponentFixture<TransacitonsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransacitonsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TransacitonsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
