function vector() {
    var array = [];

    return {
        append: function append(v) {
            array.push(v);
        },
        get: function get() {
            return array;
        }
    };
}

// Example usage
var vec = vector();
vec.append(1);
vec.append(2);
vec.append(3);
console.log(vec.get());