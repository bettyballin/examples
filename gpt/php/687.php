
function _setExtension($option) {
    static $components = array();

    if (!isset($components[$option])) {
        $filter = "'com_sef', 'com_sh404sef', 'com_joomfish', 'com_config', 'com_media', 'com_installer', 'com_templates', 'com_plugins', 'com_modules', 'com_cpanel', 'com_cache', 'com_messages', 'com_menus', 'com_massmail', 'com_languages', 'com_users'";

        // Get an instance of the database
        $db = JFactory::getDBO();

        // Escape the option value to prevent SQL injection
        $option = $db->getEscaped($option);

        // Now you can safely include $
