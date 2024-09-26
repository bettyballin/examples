
String.prototype.hashCode = function() {
    var hash = 5381;
    if (this.length === 0) return hash;
    for (var i = 0; i < this.length; i++) {
        var character  = this.charCodeAt(i);
        // Use unsigned right shift to force the result to be a 32-bit unsigned integer
