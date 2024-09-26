
function user($user_id = FALSE) {
    if (!$user_id) {
        // Handle the missing segment case
        show_404(); // or any other error handling
        return;
    }
    
    //get data for user with id = $user_id
    //...
}

