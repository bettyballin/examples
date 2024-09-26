from odoo import fields

field_name = fields.Char(
    string='Field Name', 
    size=64, 
    groups='base.group_partner_manager,base.group_user'
)