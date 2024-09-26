<?php

// Add the action hook to display the custom field on the registration form
add_action( 'register_form', 'add_register_field' );

// Function to display the custom field on the registration form
function add_register_field(){ ?>
    <p>
        <label for="user_proof">What is the answer to this question?<br />
            What color are apples usually?</label><br/>

        <input type='text' name='user_proof' id='user_proof'>
    </p>
<?php }

// Add the filter hook to validate the custom field on registration
add_filter( 'registration_errors', 'check_security_question' );

// Function to validate the custom field on registration
function check_security_question($errors){
    if ( empty($_POST['user_proof']) ) {
        $errors->add('proofempty', 'ERROR: You did not answer the proof-of-humanship question.');
        return $errors;

    } elseif( strtolower(trim($_POST['user_proof'])) != 'red' ){
        $errors->add('prooffail', 'ERROR: You did not answer the proof-of-humanship question correctly.');
        return $errors;
    }
    return $errors;
}

?>