window.__callback__ = function(json) {
    // execute the JSON object as JavaScript code
    eval("var obj = " + json);
    // now obj contains the data from the JSON object
    console.log(obj);
};

// Test the function
__callback__('{"name": "John", "age": 30}');