
$("form").submit(function(event) {
    event.preventDefault(); // Prevent form submission

    var formData = $(this).serialize();
    $.ajax({
       
