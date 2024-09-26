bash
#!/bin/bash

# delete my venv folder first
rm -rf venv

# create new venv
python3.9 -m venv venv

# activate venv
source venv/bin/activate

# install requirements
pip install -r requirements.txt