<?php

$headers = getallheaders();
if($headers['X-Auth-Token'] == 'asdflkjasdflkjasdflkjsadflkjasdf')
{
  if(isset($_GET['function']) && $_GET['function'] == 'somefunction')
  {
      echo somefunction();
  }
}
else
{
  echo "BAD TOKEN!";
}

function somefunction()
{
    return "this is the output of the server";
}

?>