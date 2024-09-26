
function myOnmessageCallback(event) {
  // Check if the message is from the current window
  if (event.source !== window) {
    // If not, ignore the message.
    return;
  }

  // The message is from the current window, so handle it here.
  // Do some useful stuff with the message.
}

// Add the event listener to the window
window.addEventListener("message", myOnmessageCallback, false);

