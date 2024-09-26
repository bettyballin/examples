const obj = Object.create(null);

// Now, this is perfectly fine (though weird):
obj.__proto__ = 'foo';
console.log(obj.__proto__);