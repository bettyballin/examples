Object.freeze(XMLHttpRequest.prototype);
// Now attempts to modify the prototype (e.g XMLHttpRequest.prototype.open = ...) will fail silently in strict mode or throw an error otherwise

// To check if a property is writable/configurable:
console.log("isWritable:", Object.getOwnPropertyDescriptor(XMLHttpRequest.prototype, "open").writable);