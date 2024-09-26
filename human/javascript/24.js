var intWidgetNumber = 1;
var js = 'console.log("Hello World!");';

var strEval =  'try{';
strEval += 'widget[' + intWidgetNumber + '] = (function(){';
strEval += js;
strEval += '})();';
strEval += '}catch(e){}';

var widget = [];
eval(strEval);