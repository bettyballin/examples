
$.ajax({
    url: 'your-endpoint',
    type: 'GET',
    dataType: 'json',
    success: function(result) {
        PopulateSeriesFields(result);
    }
});

