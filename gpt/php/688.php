
add_action( 'register_form', 'add_register_field' );
function add_register_field() {
    // Your form output here
}

add_filter( 'registration_errors', 'check_register_field', 10, 3 );
function check_register_field( $errors, $sanitized_user_login, $user_email ) {
    if ( empty( $_POST['user_proof'] ) ) {
        return $errors->add( 'proofempty', 'ERROR: You did not answer the proof-of-humanship question.' );
    } 
    else {
        // Remove spaces and convert to lowercase
        $user_input = str_replace(' ', '', strtolower( $_POST['user_proof'] ));
        
        // Compare with the expected answer
        if ( $user_input != 'serenity' ) {
            return $errors->add( 'prooffail', 'ERROR: You did not answer the proof-of-humanship question correctly.' );
        }
    }
}

