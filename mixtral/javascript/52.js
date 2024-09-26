var csrfToken = $('[name="_csrf"]').attr("content");
var csrfHeaderName = $('[name="_csrf_header"]').attr("content") || 'X-CSRF-TOKEN';

$.ajax({
    url: '/your/url',
    type: "POST",
    dataType: "json",
    headers: {
        [csrfHeaderName]: csrfToken
    },
    success: function(data) {
        console.log(data);
    },
    error: function(xhr, status, error) {
        console.log(xhr.responseText);
    }
});