<?php
if ($SysKey['user']['session_id'] != '') {
    session_set_cookie_params(60*60*24*7, '/', $SysKey['server']['site'], true, true);
}
?>