function Foo() {
  this.foo = 10;
}

function clone(obj) {
  const clonedObj = {};
  for (const key in obj) {
    if (Object.hasOwnProperty.call(obj, key)) {
      if (typeof obj[key] === 'object') {
        clonedObj[key] = clone(obj[key]);
      } else {
        clonedObj[key] = obj[key];
      }
    }
  }
  return clonedObj;
}

var x = { a: 1, b: new Foo() };
console.log(x);
var y = clone(x);
console.log(y); 
var z = {};
console.log(z.foo);