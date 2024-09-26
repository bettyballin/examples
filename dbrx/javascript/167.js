function clone_object(object) {
    var tmp = {};
    if (typeof object === 'object') {
        for (var key in object) {
            if (Object.prototype.hasOwnProperty.call(object, key)) {
                tmp[key] = object[key];
            }
        }
    }
    return tmp;
}

// Test the function
var obj = {a: 1, b: 2, c: {d: 3, e: 4}};
var clonedObj = clone_object(obj);
console.log(clonedObj);