const originalSetInnerHtml = Object.getOwnPropertyDescriptor(Element.prototype, 'innerHTML').set;
Object.defineProperty(Element.prototype, 'innerHTML', {
    set: function (newValue) {
        const valueToSet = my_function(newValue);
        // Call the original innerHTML setter
        return originalSetInnerHtml.call(this, valueToSet);
    }
});

// Example function to modify the new innerHTML value
function my_function(newValue) {
    return newValue.toUpperCase();
}

// Test the new innerHTML setter
document.body.innerHTML = "Hello, World!";