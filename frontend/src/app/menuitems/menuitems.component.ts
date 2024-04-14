import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-menuitems',
  standalone: true,
  imports: [MatButtonModule,MatIconModule, MatDividerModule, CommonModule],
  templateUrl: './menuitems.component.html',
  styleUrl: './menuitems.component.scss'
})
export class MenuitemsComponent {
// create a json array with the following fields img, title,
// description, price 
  menuitems = [
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
