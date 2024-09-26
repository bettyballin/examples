function pollAjax() {
  $.ajax({
    // assuming some ajax settings
    url: '/your-endpoint',
    method: 'GET',
    dataType: 'json'
  }).success(function(data) {
    // do something with our results
    doSomething(data);
    // Fire again to get the next set of results. 
    setTimeout(pollAjax, 10);
  });
}

// assuming doSomething function is defined somewhere
function doSomething(data) {
  console.log(data);
}

// call pollAjax to start the polling
pollAjax();