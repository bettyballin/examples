
// Library.js (as an ES6 module)
export function library(parameters) {
    return ajaxCallWithParameters(parameters);
}

// Website JavaScript:
import { library } from './Library.js';
toTable(library());

