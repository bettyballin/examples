This is not PHP code, but a Docker Compose configuration file. Here is the corrected version:


version: '2.0'

services:
  data-container-common-env:
    build:
      context: ./docker-data-container
      dockerfile: Dockerfile
    image: jkirkby91/docker-data-container
    env_file:
      - env/data.env
    restart: always
    privileged: false
    tty: false
    shm_size: 64M
    stdin_open: true


However, if you're looking to use PHP to execute a Docker Compose file, you can use the following PHP code:


<?php
exec('docker-compose up -d', $output, $return_var);
print_r($output);
?>


Make sure to save the Docker Compose configuration file as `docker-compose.yml` in the same directory as the PHP script. 

Note: The above PHP code will start the Docker containers in detached mode.