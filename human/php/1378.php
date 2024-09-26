<?php
$search_line=array(
            'file_put_contents',
            '<?',
            '<?php',
            '?>',
            'eval(',
            '$_REQUEST',
            '$_POST',
            '$_GET',
            '$_SESSION',
            '$_SERVER',
            'exec(',
            'shell_exec(',
            'invokefunction',
            'call_user_func_array',
            'display_errors',
            'ini_set',
            'set_time_limit',
            'set_magic_quotes_runtime',
            'DOCUMENT_ROOT',
            'include(',
            'include_once(',
            'require(',
            'require_once(',
            'base64_decode',
            'file_get_contents',
            'sizeof',
            'array('
        );

function findInStr($str, $arr) {
  foreach ($arr as $value) {
    if (strpos($str, $value) !== false) {
      return true;
    }
  }
  return false;
}

if(findInStr("this has some <?php echo 'PHP CODE' ?>",$search_line)){
  echo "PHP found";
}
?>