import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {MatListModule} from '@angular/material/list'; 

@Component({
  selector: 'app-transacitons',
  standalone: true,
  imports: [MatListModule, CommonModule],
  templateUrl: './transacitons.component.html',
  styleUrl: './transacitons.component.scss'
})
export class TransacitonsComponent {

  // create a json array with the following fields img, title, description, price 
  transactions = [
    {
      img: 'assets/1.svg',
      title: 'Netflix',
      description: 'Jun 03 2021, 12:00 PM',
      price: 9.99
    },
    {
      img: 'assets/2.svg',
      title: 'Starbucks',
      description: 'Jun 04 2021, 10:00 AM',
      price: 5.42
    },
    
  ];


}
