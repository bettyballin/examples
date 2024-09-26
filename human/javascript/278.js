// Create a test HTML element
var html = '<a href="https://www.example.com">Example</a>';

// Load jQuery library
var script = document.createElement('script');
script.src = "https://code.jquery.com/jquery-3.6.0.min.js";
document.head.appendChild(script);

// Wait for jQuery to load
script.onload = function() {
  // Execute the code
  $("a").each(function() {
    var href = $(this).attr("href");
    href = href.split("").reverse().join("");
    $(this).attr("href", href);
  });

  // Print the result
  console.log($("a").attr("href"));
};

// Add the test HTML element to the page
document.body.innerHTML = html;