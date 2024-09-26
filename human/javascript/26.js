(function(){
  var originalArray = Array;
  Array = function() {
    alert('I steal '+this);
  };
  [1, 2, 3];
  Array = originalArray;
})();