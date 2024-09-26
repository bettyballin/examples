String.prototype.hashCode = function(){
    var hash = 5381;

    if (this.length === 0) return hash >>> 0;

    for(var i=0, len=this.length ; i<len ; ++i){
        // Bitwise operator to convert charCodeAt() result into unsigned integer
        var character = this.charCodeAt(i) | 0;

        /*
         * The following line is equivalent to:
         * hash = ((hash << 5) + hash ) ^ character
         */

        // Bitwise operator for left shift
        hash = (hash >>> 27) + (character & 31);
    }

   return Math.abs(hash | 0);
}

// Test the function
console.log("Hello, World!".hashCode());