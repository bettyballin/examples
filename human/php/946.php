<?php

// clone the prepared template
exec('lxc-clone -o myTemplate -n newContainer');

// put the code archive in the new container
exec('cp path/to/code path/to/container/and/where/you/want');

// Start the container as a daemon
exec('lxc-start -n newContainer -d');

// Then launch the right script for the type of code in the container
exec('lxc-attach -n newContainer -- su containeruser -c /path/to/script.sh');

?>