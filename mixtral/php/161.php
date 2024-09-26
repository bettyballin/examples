<?php

function _setExtension($option) {
    static $components = array();

    if (!isset($components[$option])) {
        $filter = "'com_sef', 'com_sh404sef', 'com_joomfish', 'com_config', 'com_media', 'com_installers', 'com_templates', 'com_plugins', 'com_modules', 'com_cpanel', 'com_cache', 'com_messages', 'com_menus', 'com_massmail', 'com_languages', 'com_users'";
        $option = JDatabase::quote($option);

        // Use the escaped option in your query
        $component = ComponentDatabase::loadResult('SELECT `option` FROM #__components WHERE parent = "0" AND option NOT IN (' . $filter . ') AND option = '.$option.'');

        // Added the missing assignment to the $components array
        $components[$option] = $component;
    }
}

// Call the function to make it executable
_setExtension('test');

?>