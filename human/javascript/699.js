import { Component, ElementRef, ViewChild } from '@angular/core';
import { fromEvent } from 'rxjs';

@Component({
  selector: 'app-example',
  template: `
    <input #myInput />
  `
})
export class ExampleComponent {
  @ViewChild('myInput') myInput: ElementRef;

  ngAfterViewInit() {
    fromEvent(this.myInput.nativeElement, 'input').subscribe(console.log);
  }
}