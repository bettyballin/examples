function getPageandSelectedTextIndex() {
  console.log("getPageandSelectedTextIndex called");
}

window.addEventListener("load", function() {
  const button = document.createElement("button");
  button.id = "button";
  button.textContent = "Click me";
  document.body.appendChild(button);

  button.addEventListener("click", getPageandSelectedTextIndex, false);
}, false);