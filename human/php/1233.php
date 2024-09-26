[my_project]
listen = /tmp/php-fpm-my_project.sock
listen.mode = 0660
listen.owner = username
listen.group = www
user = username
group = www

php_admin_value[upload_max_filesize] = 100M
php_admin_value[post_max_size] = 100M
php_admin_value[memory_limit] = 256M

pm = dynamic
pm.max_children = 5
pm.start_servers = 2
pm.min_spare_servers = 1
pm.max_spare_servers = 3