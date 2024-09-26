This is a JSON object, not JavaScript code. However, I assume you want to make it a valid JavaScript object. Here is the code:


const packageJson = {
  "name": "x",
  "productName": "x",
  "version": "1.0.0",
  "description": "My Electron application description",
  "main": ".webpack/main",
  "scripts": {
    "start": "electron-forge start",
    "package": "electron-forge package",
    "make": "electron-forge make",
    "publish": "electron-forge publish",
    "lint": "echo \"No linting configured\"",
  },
  "keywords": [],
  "license": "MIT",
  "config": {
    "forge": {
      "packagerConfig": {},
      "makers": [
        {
          "name": "@electron-forge/maker-squirrel",
          "config": {
            "name": "x"
          }
        },
        {
          "name": "@electron-forge/maker-zip",
          "platforms": [
            "darwin"
          ]
        },
        {
          "name": "@electron-forge/maker-deb",
          "config": {}
        },
        {
          "name": "@electron-forge/maker-rpm",
          "config": {}
        }
      ],
      "plugins": [
        [
          "@electron-forge/plugin-webpack",
          {
            "devContentSecurityPolicy": "default-src * self blob: data: gap:; style-src * self 'unsafe-inline' blob: data: gap:; script-src * 'self' 'unsafe-eval' 'unsafe-inline' blob: data: gap:; object-src * 'self' blob: data: gap:; img-src * self 'unsafe-inline' blob: data: gap:; connect-src self * 'unsafe-inline' blob: data: gap:; frame-src * self blob: data: gap:;",
            "mainConfig": "./webpack.main.config.js",
            "renderer": {
              "config": "./webpack.renderer.config.js",
              "entryPoints": [
                {
                  "html": "./public/index.html",
                  "js": "./public/renderer.js",
                  "name": "main_window"
                }
              ]
            }
          }
        ]
      ]
    }
  },
  "devDependencies": {
    "@babel/core": "^7.15.5",
    "@babel/preset-react": "^7.14.5",
    "@electron-forge/cli": "^6.0.0-beta.60",
    "@electron-forge/maker-deb": "^6.0.0-beta.60",
    "@electron-forge/maker-rpm": "^6.0.0-beta.60",
    "@electron-forge/maker-squirrel": "^6.0.0-beta.60",
    "@electron-forge/maker-zip": "^6.0.0-beta.60",
    "@electron-forge/plugin-webpack": "6.0.0-beta.60",
    "@vercel/webpack-asset-relocator-loader": "1.7.0",
    "babel-loader": "^8.2.2",
    "css-loader": "^6.0.0",
    "electron": "^15.3.1",
    "install": "^0.13.0",
    "node-loader": "^2.0.0",
    "npm": "^7.22.0",
    "react": "^17.0.2",
    "react-dom": "^17.0.2",
    "style-loader": "^3.0.0"
  },
  "dependencies": {
    "@date-io/date-fns": "^1.3.13",
    "@date-io/moment": "^2.10.11",
    "@material-ui/core": "^4.11.4",
    "@material-ui/icons": "^4.11.2",
    "@material-ui/pickers": "^4.0.0-alpha.12",
    "@testing-library/jest-dom": "^5.11.4",
    "@testing-library/react": "^11.1.0",
    "@testing-library/user-event": "^12.1.10",
    "@wojtekmaj/react-daterange-picker": "^3.2.0",
    "@y0c/react-datepicker": "^1.0.4",
    "aes-js": "^3.1.2",
    "ag-grid-community": "^25.3.0",
    "ag-grid-react": "^25.3.0",
    "axios": "^0.21.1",
    "base-64": "^1.0.0",
    "bootstrap": "^4.6.0",
    "bootstrap-daterangepicker": "^3.1.0",
    "crypto-js": "^4.1.1",
    "date-fns": "^2.22.1",
    "electron-splashscreen": "^1.0.0",
    "electron-squirrel-startup": "^1.0.0",
    "hex64": "^0.4.0",
    "jquery": "^3.6.0",
    "lottie-react": "^2.1.0",
    "moment": "^2.29.1",
    "moment-timezone": "^0.5.32",
    "node-jsencrypt": "^1.0.0",
    "prop-types": "^15.7.2",
    "qrcode": "^1.4.4",
    "react-bootstrap-daterangepicker": "^7.0.0",
    "react-custom-scrollbars-2": "^4.4.0",
    "react-date-range": "^1.2.0",
    "react-dropdown-input": "^0.1.11",
    "react-geolocated": "^3.2.0",
    "react-live-clock": "^5.2.0",
    "react-lottie": "^1.2.3",
    "react-moment": "^1.1.1",
    "react-native-qrcode-svg": "^6.1.1",
    "react-native-svg": "^12.1.1",
    "react-otp-input": "^2.3.1",
    "react-qr-code": "^2.0.2",
    "react-responsive": "^8.2.0",
    "react-router-dom": "^5.2.0",
    "react-scripts": "4.0.3",
    "react-scroll": "^1.8.3",
    "react-table": "^7.7.0",
    "react-to-print": "^2.13.0",
    "react-virtualized": "^9.22.3",
    "react-virtualized-auto-sizer": "^1.0.5",
    "react-window": "^1.8.6",
    "reactstrap": "^8.9.0",
    "rsuite": "^4.10.2",
    "systeminformation": "^5.8.7",
    "text-to-binary-converter": "^1.0.2",
    "web-vitals": "^1.0.1",
    "zustand": "^3.5.7"
  }
};