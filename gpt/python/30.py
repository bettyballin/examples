
from setuptools import setup
from setuptools.command.install import install
import os

home = os.path.expanduser('~')
did_xml_path = os.path.join(home, '.did', 'did.xml')

class CustomInstallCommand(install):
    """Customized setuptools install command to change file permissions."""
    def run(self):
        install.run(self)  # Call the original install command
        if os.path.exists(did_xml_path):
            os.chmod(did_xml_path, 0o666)  # set the desired permission

setup(
    name='did',
    version='1.0',
    description='Daily Image Downloader',
    author='Luc Mazon',
    author_email='my@mail.com',
    url='',
    license
