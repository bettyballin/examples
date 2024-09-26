HTMLElement.prototype.onAttributeChange = function (c) {
    let observer = new MutationObserver(c);
    observer.observe(this,{attributes:true});
};

// Create a new HTML element for testing purposes
var elem = document.createElement("input");
elem.id = "txtpassword";
document.body.appendChild(elem);

elem.onAttributeChange(function(mutations){
    alert("attribute changed");
});

// Test the code by changing an attribute of the element
elem.setAttribute("type", "password");