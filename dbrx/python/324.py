from flask import render_template, request, redirect, url_for
from yourapp import app
from yourapp.models import Student

@app.route('/students', methods=['GET', 'POST'])
@login_required
@require_admin
def students():
    if request.method == 'POST':
        name = request.form.get('name')
        email = request.form.get('email')
        student = Student(name=name, email=email)
        student.save()
        return redirect(url_for('students'))
    students = Student.query.all()
    return render_template('students.html', students=students)