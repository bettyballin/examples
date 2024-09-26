function makePropReader(propName) {
    return function(obj) {
        return obj[propName];
    }
}

// Test the function
const reader = makePropReader('name');
const obj = { name: 'John Doe', age: 30 };
console.log(reader(obj));  // Outputs: John Doe