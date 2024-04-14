import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CreditcardComponent } from './creditcard/creditcard.component';
import { TransacitonsComponent } from './transacitons/transacitons.component';
import { MenuitemsComponent } from './menuitems/menuitems.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CreditcardComponent,TransacitonsComponent,MenuitemsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'card';
}
