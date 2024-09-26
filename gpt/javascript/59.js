
(function() {
    // This variable is not accessible outside of this IIFE
    var restricted = "I'm hidden";

    window.safeFunction = function() {
        // This function cannot access the 'restricted' variable
        console.log('This function is restricted.');
    };
})();

// Usage
safeFunction(); // Works
console.log(restricted); // ReferenceError: restricted is not defined

