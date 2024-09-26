var clone = function(object) {
    return Object.assign({}, object);
}

// test the function
var original = { a: 1, b: 2 };
var copy = clone(original);

console.log(copy); // outputs: { a: 1, b: 2 }

// modify the original object
original.a = 3;

console.log(copy); // outputs: { a: 1, b: 2 }