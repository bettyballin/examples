bash
#!/bin/bash

pip install --platform manylinux2014_x86_64 --implementation cp --python 3.9 --only-binary=:all: --upgrade --target /home/packages cryptography
pip install --target=/home/packages pyjwt[crypto]==2.6.0 
pip install --target=/home/packages pymongo[srv]==4.3.3