<?php
$your_array = array(
  'client'  => '1234',
  'acc_no'  => '12345',
  'test'    => array(
    'acc_no'  => '12',
    'acc'    => '12345'
  )
);

function unset_sensitive_keys( &$array, $delete_keys )  {
  foreach( $array as $key => &$value ) {
    if( is_array( $value ) )  {
      unset_sensitive_keys( $value, $delete_keys );
    } else {
      if( in_array( $key, $delete_keys )  ) {
        unset($array[$key]);
      }
    }
  }
}

unset_sensitive_keys( $your_array, array( 'acc_no', 'account_no' ) );

print_r($your_array);
?>