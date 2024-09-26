
if __name__ == "__main__":
    app = web.application(urls, globals())
    app.run(host='127.0.0.1', port=8080)

