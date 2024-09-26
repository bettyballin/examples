<?php
// Check if user is logged in 
if (!$this->ion_auth->logged_in())
{
    //Not logged in , so redirect them to login page
    redirect('account/login', 'refresh');
}

else{
    // So the user is logged in 
    // Get the id of the currently logged in user ( The user who is trying to view the page )
    $current_user = $this->ion_auth->get_user();
    $current_userid = $current_user->id;

    // you need an array of users who have been invited to that event by the event creator
    // As you mentioned you are storing the users who have been invited in db, get the ids to an array 

    $invited_users = getIdsOfusers();

    if (in_array($current_userid, $invited_users)) {
        // Yes, The user who is trying to view the page has access
        // you can show him the respective view
        $this->load->view('your_view');
    }
    else {
        // No, The user who is trying to view the page Doesn't have  access
        show_error('You dont have access !', 500);
    }
}
?>