function getUniqueNumbers() {
  var arr = []
  while (arr.length < 3) {
    var someRand = Math.ceil(Math.random() * 36)
    if (arr.indexOf(someRand) > -1) continue;
    arr[arr.length] = someRand;
  }
  return arr;
}

var luckyNumbers = getUniqueNumbers();
var winImg = "<img  src='https://mcthompsonatl.github.io/images/keytowin/frontImage.png' alt='X LOGO'>";
var loseImg = "<img  src='https://mcthompsonatl.github.io/images/keytowin/TryAgain.png' alt='X LOGO'>";

console.log(luckyNumbers);

$(document).ready(function() {
  $(".card").on("click", function() {
    if (!$(this).hasClass("clicked")) {
      $(this).addClass("clicked");
      selected = Number($(this).attr("data-id"));
      if (luckyNumbers.indexOf(selected) > -1) {
        $(this).find(".back").append(winImg);
      } else {
        console.log("wrong: " + selected);
        $(this).find(".back").append(loseImg);
      }
    }
  });
});