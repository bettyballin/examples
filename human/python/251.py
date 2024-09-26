#!/bin/bash

sudo apt-get install subversion
sudo apt-get install m4
sudo apt-get install flex
sudo apt-get install bison
sudo apt-get install libssl-dev
sudo apt-get install python3-setuptools python3-dev
sudo apt-get install libgmp-dev

wget http://crypto.stanford.edu/pbc/files/pbc-0.5.14.tar.gz
tar xf pbc-0.5.14.tar.gz
cd pbc-0.5.14
./configure && make && sudo make install