Here is the executable JavaScript code:


import { BrowsePolicy } from 'meteor/browser-policy-common';

BrowserPolicy.framing.disallow();
BrowserPolicy.content.disallowInlineScripts();
BrowserPolicy.content.disallowEval();
BrowserPolicy.content.allowInlineStyles();
BrowserPolicy.content.allowFontDataUrl();

const trusted = [
  'fonts.googleapis.com',
  'fonts.gstatic.com',
  'code.ionicframework.com'
];

trusted.forEach((origin) => {
  BrowserPolicy.content.allowOriginForAll(origin);
});

BrowserPolicy.content.allowWorkerSrc('self blob:');