function vector() {
    var array = [];

    const methods = {
        append: function (v) {
            array.push(v);
        },

        get: function (i) {
            return array[i];
        },

        // ... other methods
    };

    Object.freeze(methods);

    const instance = {};

    for (let method in methods)
        if (Object.prototype.hasOwnProperty.call(methods, method))
            instance[method] = methods[method].bind({ array });

    return instance;
}

// Test the vector function
const v = vector();
v.append(1);
v.append(2);
v.append(3);
console.log(v.get(0));  // Output: 1
console.log(v.get(1));  // Output: 2
console.log(v.get(2));  // Output: 3