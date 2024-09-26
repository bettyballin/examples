const sig1 = "DK9kn+7klT2Hv5A6wRdsReAo3xY=";
const sig2 = '12,175,100,159,238,228,149,61,135,191,144,58,193,23,108,69,224,40,223,22';
const sig1AsNumArrayString = atob(sig1).split('').map(c => c.charCodeAt(0)).toString();
console.log(sig2 === sig1AsNumArrayString)