const electron = require('electron');
electron.webFrame.registerURLSchemeAsPrivileged('app');
electron.webFrame.registerURLSchemeAsPrivileged('file');
electron.webFrame.registerURLSchemeAsPrivileged('https');
electron.webFrame.registerURLSchemeAsPrivileged('http');

electron.webFrame._exemptionsFromCSP = ["script-src 'unsafe-inline'"];