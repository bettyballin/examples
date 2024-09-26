
$(element).on('click', function(event) {
  if (event.originalEvent === undefined) {
    // The event was triggered by the code, not by a user action.
    return;
  }
  // Rest of your code here...
});

