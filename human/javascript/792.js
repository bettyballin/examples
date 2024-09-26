function vector() {
    var array = [];
    return {
        append: function append(v) {
            array.push(v);
        },
        get: function get(i) {
            return array[i];
        },
        store: function store(i,v) {
            array[i] = v;
        }
    };
}

var v = vector();
v.append(1);
v.append(2);
var internalData = exploitVector(v); 
console.log(internalData); // [1, 2]


function exploitVector(v) {
    var visible_array;
    v.store('push', function(x){visible_array=this}) 
    v.append(12)                                     
    return visible_array
}