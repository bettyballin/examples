const targetNode = document.getElementById('yourInputId');

// Create a MutationObserver instance with a callback function
const observer = new MutationObserver((mutationsList) => {
  for(const mutation of mutationsList) {
    if(mutation.attributeName === 'type' && mutation.target.type !== 'password') {
      // Handle the type change here e.g revert it back to password or log an error.
      console.error('Input type has been changed from "password"');
      targetNode.type = 'password';
    }
  }
});

// Options for MutationObserver
const config = { attributes: true };

// Start observing changes on the input element
observer.observe(targetNode, config);