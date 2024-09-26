
    document.addEventListener('dragstart', function(e) {
      if (e.target.nodeName === 'IMG') {
        e.preventDefault();
      }
    });
    
