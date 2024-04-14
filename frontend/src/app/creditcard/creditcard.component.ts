import { Component } from '@angular/core';
import { TransacitonsComponent } from '../transacitons/transacitons.component';
import {MatCardModule} from '@angular/material/card'; 

@Component({
  selector: 'app-creditcard',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './creditcard.component.html',
  styleUrl: './creditcard.component.scss'
})
export class CreditcardComponent {

}
