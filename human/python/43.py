import sys
import web

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python code.py <ip>")
        sys.exit(1)

    ip = sys.argv[1]
    port = 8080

    urls = (
        '/', 'index'
    )

    class index:
        def GET(self):
            return "Hello, world!"

    app = web.application(urls, globals())
    app.run(ip, port)

    print(f"http://{ip}:{port}/")