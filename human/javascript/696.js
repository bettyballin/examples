var tmp = {}
var tmp2 = {x: 10};
Object.setPrototypeOf(tmp, tmp2);
console.log(tmp.x); // outputs: 10