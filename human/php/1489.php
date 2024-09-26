<?php

/**
 * Check if credit card is from a us country
 */
add_action( 'woocommerce_after_checkout_validation', 'validate_credit_card', 10, 2 );
function validate_credit_card( $data, $errors ) {
    $bin      = substr($data['payment_method_data']['cc-number'], 0, 8); // get first 8 digits of credit card number
    $response = wp_safe_remote_get( 'https://lookup.binlist.net/' . $bin );

    if ( isset( $response['body'] ) ) {
        $response_body = json_decode( $response['body'] );

        if ( $response_body->country->alpha2 !== 'US' ) {
            $errors->add( 'credit_card_error', 'Your credit card is not from a US country.' );
        }
    } else {
        $errors->add( 'credit_card_error', 'Unable to check your credit card.' );
    }
}