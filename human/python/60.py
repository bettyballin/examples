import cgi
import wsgiref.handlers
import webapp2

class DDTHandler(webapp2.RequestHandler):

    def __start_display(self):
        self.response.out.write("<!--\n")

    def __end_display(self):
        self.response.out.write("-->\n")

    def __show_dictionary_items(self,dictionary,title):
        if (len(dictionary) > 0):
            request = self.request
            out = self.response.out
            out.write("\n" + title + ":\n")
            for key, value in dictionary.items():
                out.write(key + " = " + value + "\n")

    def __show_request_members(self):
        request = self.request
        out = self.response.out
        out.write(request.url+"\n")
        out.write("Query = "+request.query_string+"\n")
        out.write("Remote = "+request.remote_addr+"\n")
        out.write("Path = "+request.path+"\n\n")
        out.write("Request payload:\n")
        if (len(request.arguments()) > 0): 
            for argument in request.arguments():
                value = cgi.escape(request.get(argument))
                out.write(argument+" = "+value+"\n")
        else:
            out.write("Empty\n")

        self.__show_dictionary_items(request.headers, "Headers")
        self.__show_dictionary_items(request.cookies, "Cookies")

    def view_request(self):
        self.__start_display()
        self.__show_request_members()
        self.__end_display()

    def view(self, aString):
        self.__start_display()
        self.response.out.write(aString+"\n")
        self.__end_display()

app = webapp2.WSGIApplication([
    ('/', DDTHandler),
], debug=True)

def main():
    run_wsgi_app(app)

if __name__ == "__main__":
    main()