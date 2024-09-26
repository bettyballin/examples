
import { BrowserPolicy } from 'meteor/browser-policy-common';
import _ from 'underscore';

BrowserPolicy.framing.disallow();
BrowserPolicy.content.disallowInlineScripts();
BrowserPolicy.content.disallowEval();
BrowserPolicy.content.allowInlineStyles();
BrowserPolicy.content.allowFontDataUrl();

// Allow `blob:` URLs for workers
BrowserPolicy.content.allowWorkerSource("blob:");

const trusted = [
  'fonts.googleapis.com',
  'fonts.gstatic.com',
  'code.ionicframework.com',
];

_.each(tr
