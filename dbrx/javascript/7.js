$.ajax({
    url: 'your-api-endpoint.php',
    type: 'POST', // or GET depending on your needs
    data: { /* any necessary parameters */ },
    beforeSend: function(xhr) {
        xhr.setRequestHeader('X-CSRF-Token', '<?php echo $_SESSION["csrf_token"]; ?>');
        
        if (!<?php echo isset($_SESSION["loggedIn"]) ? 1 : 0; ?>) {
            alert('Access denied');
            return false;
        }
    },
    success: function(data) {
        // Handle the response here...
    }
});