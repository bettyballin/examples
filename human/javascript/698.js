import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-example',
  template: `
    <input [formControl]="myInput">
  `
})
export class ExampleComponent {
  myInput = new FormControl('');

  constructor() {
    this.myInput.valueChanges.subscribe(console.log);
  }
}