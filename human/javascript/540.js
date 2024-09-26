function acceptenceCriteria() {
    return true; // placeholder for your logic
}

$("body").append("<button id='FooBar'>Click me!</button>");

$("#FooBar").click(function() {
    if (!acceptenceCriteria.call(this)) {
        return;
    }
    alert('Disabled: ' + $(this).is('[disabled=disabled]'));    
})