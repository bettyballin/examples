from flask import Flask, request
import os

app = Flask(__name__)

class ProjectName:
    def __init__(self, form):
        self.form = form

    def validate_on_submit(self):
        # Add validation logic here
        return True

@app.route('/create', methods=['POST'])
def create():
    form = ProjectName(request.form)

    # Check for validation errors
    if not form.validate_on_submit() or 'name' not in request.values:
        return "Invalid input", 400

    project_name = os.path.basename(os.path.normcase(request.form['name']))

    # Check for directory traversal
    if any([not allowed for allowed in ['../', '..\\'] if allowed in project_name]):
        return "Invalid input", 400

    path = os.path.join('data', project_name)

    try:
        os.makedirs(path)

    except FileExistsError as e:
        # Handle existing directory
        return "Folder already exists", 400

    except Exception as e:
        return "Failed to create the folder", 500

    return f"Folder created at {path}", 201

if __name__ == '__main__':
    app.run(debug=True)