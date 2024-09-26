var Clone = {
    clone_object: function (object) {
        var tmp = {};
        if (typeof object === 'object') {
            for (var key in object) {
                if (Array.isArray(object[key])) {
                    tmp[Object.keys(tmp).length] = this.clone_array(object[key]);
                } else if (key !== '__proto__' && typeof object[key] === 'object') {
                    tmp[key] = this.clone_object(object[key]);
                } else {
                    tmp[key] = object[key];
                }
            }
        }
        return tmp;
    },
    clone_array: function(arr) {
        return arr.slice();
    }
};

// Test the code
var original = {
    a: 1,
    b: [2, 3],
    c: {
        d: 4,
        e: [5, 6]
    }
};

var cloned = Clone.clone_object(original);
console.log(cloned);