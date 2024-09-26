function check_input(input_table) {
    $.ajax({
        type: "POST",
        url: site_url + "/site/check_input",
        data: {
            input: input_table
        },
        success: function (resp) {
            var is_unique = resp;
            console.log(is_unique);
        }
    });
}

// Example usage:
check_input("example_input");