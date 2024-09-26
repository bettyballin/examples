from flask import request, abort

@app.route('/your_route', methods=['POST'])
def your_function():
    if request.method == 'POST':
        # Your code here
        pass
    else:
        return abort(405)