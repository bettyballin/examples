var clone = function(object) {
    return Object.create(object);
}

// Test the function
var original = { foo: 'bar' };
var cloned = clone(original);

console.log(cloned.foo); // outputs: bar

// Modify the cloned object
cloned.foo = 'baz';

console.log(original.foo); // outputs: bar
console.log(cloned.foo); // outputs: baz