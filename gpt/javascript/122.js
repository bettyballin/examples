
// Overriding the Array constructor
Array = function() {
    console.log("Array constructor has been overridden!");
    // Potentially malicious code could go here
    // For example, an attacker might want to track the arrays being created or manipulate them
    return [];
};

// Now, whenever the Array constructor is used, the overridden version will execute
var myArray = new Array(); // This will trigger the overridden constructor

