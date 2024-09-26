
document.addEventListener('mouseup', function() {
  if (window.getSelection) {
    window.getSelection().removeAllRanges();
  } else if (document.selection) {  // For IE
    document.selection.empty();
  }
});

