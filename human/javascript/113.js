$.ajax({
  type: 'GET',
  url: 'URL which does NOT contain callback=?',
  dataType: 'jsonp',
  success: function(data) {
    // do something with data
  }
});