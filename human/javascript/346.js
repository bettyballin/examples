String.prototype.hashCode = function(){
    var hash = 5381;
    if (this.length === 0) return hash;
    for (var i = 0; i < this.length; i++) {
        var character  = this.charCodeAt(i);
        hash = ((hash << 5) - hash) + character;
        hash |= 0;
    }
    return hash >>> 0;
}

// Test the function
console.log("Hello World".hashCode());