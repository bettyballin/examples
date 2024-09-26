// script.js
export const blah = "blah";

// gui/textbox.js
export const blah2 = "blah2";

// index.js
import { blah } from './script.js';          
import { blah2 } from './../gui/textbox.js';  

console.log(blah);
console.log(blah2);