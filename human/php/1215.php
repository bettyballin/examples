<?php

function php7_unserialize($str, $options = array())
{
  if(version_compare(PHP_VERSION, '7.0.0', '>='))
  { return unserialize($str, $options); }

  $allowed_classes = isset($options['allowed_classes']) ?
    $options['allowed_classes'] : true;
  if(is_array($allowed_classes) || !$allowed_classes)
  {
    $str = preg_replace_callback(
      '/(?=^|:)(O|C):\d+:"([^"]*)":(\d+):{/',
      function($matches) use ($allowed_classes)
      {
        if(is_array($allowed_classes) &&
          in_array($matches[2], $allowed_classes))
        { return $matches[0]; }
        else
        {
          return $matches[1].':22:"__PHP_Incomplete_Class":'.
            ($matches[3] + 1).
            ':{s:27:"__PHP_Incomplete_Class_Name";'.
            serialize($matches[2]);
        }
      },
      $str
    );
  }
  unset($allowed_classes);
  return unserialize($str);
}

// Test the function
$str = 'O:3:"Foo":1:{s:3:"bar";s:3:"baz";}';
$options = array('allowed_classes' => array('Foo'));
print_r(php7_unserialize($str, $options));

?>