bash
#!/bin/bash

export KERNEL_BITS=64
./Configure Cygwin-x86_64 shared no-ssl2 no-ssl3 --openssldir="$HOME/ssl"
make depend
make
make install_sw