const fs = require('fs');
const jsdom = require('jsdom');
const { JSDOM } = jsdom;

const file1 = fs.readFileSync('file.js', 'utf8');
const file2 = fs.readFileSync('subdir/anotherfile.js', 'utf8');

const dom1 = new JSDOM(file1);
const dom2 = new JSDOM(file2);

console.log(dom1.window.document.body.textContent);
console.log(dom2.window.document.body.textContent);