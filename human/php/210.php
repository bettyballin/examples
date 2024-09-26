<?php
function systemWide($ttl = 86400, $exit = 360)
{
    if (extension_loaded('apc') === true)
    {
        $key = array(__FUNCTION__);

        if (apc_exists(__FUNCTION__) !== true)
        {
            apc_store(__FUNCTION__, 0, $ttl);
        }

        $result = apc_inc(__FUNCTION__, 1);

        if ($result < $exit)
        {
            return ($result / $ttl);
        }

        return true;
    }

    return false;
}

// Test the function
var_dump(systemWide());
?>