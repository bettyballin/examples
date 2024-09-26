This is not PHP code, it's a Docker Compose configuration file. However, I can provide you with a PHP script that can be used to run this Docker Compose configuration:


<?php
exec('docker-compose up -d', $output, $return_var);
if ($return_var === 0) {
    echo "Docker containers started successfully\n";
} else {
    echo "Error starting Docker containers\n";
    print_r($output);
}


However, please note that this PHP script assumes that the Docker Compose configuration file is in the same directory and is named `docker-compose.yml`. Also, this script starts the containers in detached mode. 

If you want to make the Docker Compose configuration executable, you can add a shebang line at the top of the file and make the file executable:

bash
#!/usr/bin/env docker-compose

version: '2.0'

services:
  logging-common-env:
    build:
      context: ./logging
      dockerfile: Dockerfile
    image: jkirkby91/docker-data-container    
    env_file: 
      - env/logging.env           
    restart: always
    working_dir: /data/log
    privileged: false 
    tty: false
    shm_size: 64M
    stdin_open: true       
    read_only: false


Then, make the file executable:

bash
chmod +x docker-compose.yml


Now you can run the Docker Compose configuration as a script:

bash
./docker-compose.yml up -d