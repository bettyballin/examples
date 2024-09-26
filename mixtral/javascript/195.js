var html = "<button id='button'>Click me</button>";

$(html).find("#button").on('click', function () {
  alert("hello");
});