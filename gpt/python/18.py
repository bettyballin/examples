
   self.cookie[_COOKIE_NAME]['httponly'] = True
   if os.environ.get('HTTPS') == "on":
       self.cookie[_COOKIE_NAME]['secure'] = True
   
