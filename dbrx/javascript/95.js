Object.defineProperty(Element.prototype, 'innerHTML', {
  set: function(value) {
    var new_value = my_function(value);
    return Reflect.set(this, 'innerHTML', new_value);
  }
});

// Assuming my_function is defined somewhere
function my_function(value) {
  // do something with value
  return value;
}

// Test the code
document.body.innerHTML = 'Hello, World!';