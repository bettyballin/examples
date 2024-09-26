(() => {
  if (process.env.NODE_ENV === 'production') {
    if (typeof __REACT_DEVTOOLS_GLOBAL_HOOK__ !== 'undefined') {
      __REACT_DEVTOOLS_GLOBAL_HOOK__.inject = () => {};
    } else {
      console.warn('__REACT_DEVTOOLS_GLOBAL_HOOK__ is not defined');
    }
  }
})();