Object.prototype.__defineSetter__('x', function(x) {
    alert('Ha! I steal '+x);
});

var obj = {};
obj.x = 10;