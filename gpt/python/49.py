
if __name__ == "__main__":
    app = web.application(urls, globals())
    port = 8080
    web.httpserver.runsimple(app.wsgifunc(), ("127.0.0.1", port))

