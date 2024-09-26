$.ajax({
    url: link,
    dataType: 'jsonp',
    success: function (response) {
        $('#FooSection').replaceWith(response);
    }
});