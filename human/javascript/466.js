(function() {
  
  //Store the original "hidden" getter and setter functions from Element.prototype
  //using Object.getOwnPropertyDescriptor
  var originalSet = Object.getOwnPropertyDescriptor(Element.prototype, 'innerHTML').set;
  
  Object.defineProperty(Element.prototype, 'innerHTML', {
    set: function (value) {
        // change it (ok)
        var new_value = my_function(value);
        
        //Call the original setter
        return originalSet.call(this, new_value);
    }
  });
                        
  function my_function(value) {
    //Do whatever you want here
    return value + ' World!';
  }
                        
})();

// Create an element with id 'test'
var testElement = document.createElement('div');
testElement.id = 'test';
document.body.appendChild(testElement);

//Test
document.getElementById('test').innerHTML = 'Hello';