// Assuming jQuery is already included

String.prototype.cleanHTML = function() {
  return this.replace(/<[^>]+>/g, '');
};

String.prototype.clean = function() {
  return this.trim().replace(/[\r\n]+/g, ' ').replace(/\s{2,}/g, ' ');
};

let content = $('body').html().cleanHTML().clean();

// For testing
console.log(content);