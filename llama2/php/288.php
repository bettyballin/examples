<?php
session_start();

// Generate a unique token for the user
$token = bin2hex(random_bytes(32));
$_SESSION['token'] = $token;

?>

<script>
    $(document).ready(function(){
        // Include the token in the AJAX request
        $.post('<?php echo $url; ?>/save_results', {
            _token: '<?php echo $token; ?>',
            code: $('.codes_input').val()
        }, function(data){
            points = points + 10;
            $('.code').html(randomString());
            $('.codes_input').val('');
            $('.points').html(points);
        });
    });
</script>

<?php

// On the server-side verify the token before updating the user's points
if(isset($_POST['_token']) && $_POST['_token'] === $_SESSION['token']){
    // Update the user's points
    echo "Points updated successfully";
}else{
    // Token is invalid return an error
    echo "Invalid token";
}
?>