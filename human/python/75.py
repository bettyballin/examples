from odoo import fields, models

class YourModel(models.Model):
    _inherit = 'your.model'

    employee_is_in_thw_emp = fields.Boolean(invisible=True)
    employee_id = fields.Many2one('hr.employee', attrs={'readonly': [('employee_is_in_thw_emp', '=', True)]})