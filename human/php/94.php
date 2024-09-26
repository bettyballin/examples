<?php
exec('ssh -L 3306:localhost:3306 -N someuser@mysql.server.address');
?>