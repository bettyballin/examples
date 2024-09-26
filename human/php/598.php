This is not PHP code, it's an Apache .htaccess file. However, I can provide you with the corrected version:


Options -Indexes
Options +FollowSymLinks
RewriteEngine On
RewriteBase /

#Removes access to the system folder by users.
#Additionally this will allow you to create a System.php controller,

RewriteCond %{REQUEST_URI} ^system.*
RewriteRule ^(.*)$ index.php?/$1 [L]

#When your application folder isn't in the system folder

RewriteCond %{REQUEST_URI} ^application.*
RewriteRule ^(.*)$ /index.php?/$1 [L]

#Checks to see if the user is attempting to access a valid file,
#such as an image or css document, if this isn't true it sends the
#request to index.php

RewriteCond %{REQUEST_FILENAME} !-f
RewriteCond %{REQUEST_FILENAME} !-d
RewriteRule ^(.*)$ index.php?/$1 [L]

# If we don't have mod_rewrite installed, all 404's
# can be sent to index.php, and everything works as normal.
# Submitted by: ElliotHaughin   

ErrorDocument 404 /index.php


Note: Please replace `RewriteBase /` with your actual base domain path. 

Also, please note that .htaccess files are not PHP code and are used to configure Apache servers. They should be placed in the root directory of your website, not executed as PHP code.