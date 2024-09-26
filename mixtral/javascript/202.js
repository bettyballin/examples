var myIframe = document.createElement('iframe');
myIframe.src = 'https://example-crossorigin.com';
document.body.appendChild(myIframe);

// Listen for message from child frame
window.addEventListener("message", function (event) {
  if (event.data === "loaded") {
    console.log('iframe content loaded');
  }
});