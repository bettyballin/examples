
if (typeof window.addEventListener === "undefined" && typeof document.attachEvent === "function") {
    // This is an old version of IE that uses attachEvent instead of addEventListener
    // Proceed to set up event listeners using attachEvent
    Element.prototype.addEventListener = function(eventType, listener) {
        return this.attachEvent('on' + eventType, function(e) {
            e = e || window.event;
