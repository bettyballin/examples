const alertRef = console.log;
console.log = alert;
alert = alertRef;

console.log("Hello World!");
alert("Hello World!");