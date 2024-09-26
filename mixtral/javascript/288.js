class Vector {
  constructor() {
    this.array = [];
  }

  append(value) {
    this.array.push(value);
  }

  get(index) {
    return this.array[index];
  }
}

var v = new Vector();
v.append(1);

// Override 'get' method
v.get = function () {
  return this.array;
};

console.log(v.get()); // [1]