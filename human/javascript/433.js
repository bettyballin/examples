Object.defineProperty(Math, "random", { 
    configurable: false,
    writable: false 
});

// Test the code
console.log(Math.random());