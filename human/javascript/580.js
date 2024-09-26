// save the original function
const OBJECT_DEFINE_PROPERTY = Object.defineProperty;

// overwrite Object.defineProperty with our own wrapped version
Object.defineProperty = function (obj, prop, vals) {

    // modify values/writability as required, if it's a property we want control over
    if (prop === 'testProperty') {
        vals.value = 'modified value';
        vals.writable = false;
    }

    // call the original function to define our (modified) property
    return OBJECT_DEFINE_PROPERTY(obj, prop, vals);
};

// test the modified function
const obj = {};
Object.defineProperty(obj, 'testProperty', { value: 'original value', writable: true });
console.log(obj.testProperty); // outputs: "modified value"

try {
    obj.testProperty = 'new value';
} catch (e) {
    console.log(e); // outputs: TypeError: Cannot assign to read only property 'testProperty' of object '[object Object]'
}