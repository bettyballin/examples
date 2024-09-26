function delete(someid) {
    $.ajax({
        type: 'POST',
        url: '/delete',
        headers: {'X-CSRFToken': getCookie('csrftoken')},
        data: {
            id: someid,
            csrfmiddlewaretoken: getCookie('csrftoken')
        }
    });
}

// example usage:
delete(123);