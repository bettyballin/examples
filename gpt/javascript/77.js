
function resolve_entities(str) {
  var span = document.createElement('span');
  var limit = 5; // Define a limit to prevent potential infinite loops
  
  // Set the string as the innerHTML of the span element to decode entities
  span.innerHTML = str;
  
  // Repeatedly decode until there are no more entities or the limit is reached
  for (var i = 0; i < limit && span.innerHTML !==
