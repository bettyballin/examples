const NodeRSA = require('node-rsa');

let key = new NodeRSA({b: 512});

key.importKey(
    {
        n: '0x00c4c7f27227a8e3837a89d3180511241c7a709d94dca09a1f872d89d78f3e8487b3b0d78674f4a14197a831ad53e113',
        e: '0x10001',
        d: '0x04315e0bd31b09319eed1f426dadf2c9a1b4c2c20c62f8e1d36d44331e4f6d96257a2f5c9476981040b93ad04df9a89',
        p: '0x00f1b8a7b75e64b1f1b92075076813f1dcf31fa1879828c3f4f2e60760e5aaf3',
        q: '0x00c80047c86f0b0852c1d82a1a485a03c5980d8e67c0e13e8f0472ec71c9e921',
        dmp1: '0x00e92d47f1670a198b8f17f1c3e146f6da5dcc24f1c93f6a9a1b6d5b4d4bb79',
        dmq1: '0x00c5a2abe071ec19b97d6f6390e5a0d1820dd0081f2d1b36142e14d640b37381'
    },
    'components'
);

console.log(key.exportKey('pkcs8-private'));