// In the iframe
window.parent.postMessage("getScrollTop", "*");

var scrollTop;
window.addEventListener("message", function(event) {
  if (event.data === "scrollTop") {
    scrollTop = event.data;
  }
});