// Store the original forEach function
var originalForEach = Array.prototype.forEach;

// Override the forEach function
Array.prototype.forEach = function (e){
  console.log("something wrong there");
  return(e);
};

// Test the overridden function
[1, 2, 3].forEach(function(item) {
  console.log(item);
});

// Restore the original forEach function (optional)
Array.prototype.forEach = originalForEach;

// Test the restored function (optional)
[1, 2, 3].forEach(function(item) {
  console.log(item);
});