import os

LIBPATH = r"C:\WINDOWS\Microsoft.NET\Framework\v3.5;C:\WINDOWS\Microsoft.NET\Framework\v2.0.50727;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\ATLMFC\LIB;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\LIB;C:\Python33\Lib;C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\Lib;%LIBPATH%"
PATH = r"C:\Program Files (x86)\Microsoft Visual Studio 10\Common7\IDE;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\BIN;C:\Program Files (x86)\Microsoft Visual Studio 10\Common7\Tools;C:\WINDOWS\Microsoft.NET\Framework\v3.5;C:\WINDOWS\Microsoft.NET\Framework\v2.0.50727;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\VCPackages;%WindowsSdkDir%bin;C:\Python33\Scripts;C:\Python33;%PATH%"
INCLUDE = r"C:\Program Files (x86)\Microsoft Visual Studio 10\VC\ATLMFC\INCLUDE;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\INCLUDE;%WindowsSdkDir%include;C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\Include;C:\Python33\include;%INCLUDE%"
LIB = r"C:\Program Files (x86)\Microsoft Visual Studio 10\VC\ATLMFC\LIB;C:\Program Files (x86)\Microsoft Visual Studio 10\VC\LIB;%WindowsSdkDir%lib;C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\Lib;C:\Python33\Lib;%LIB%"

os.environ['LIBPATH'] = LIBPATH
os.environ['PATH'] = PATH
os.environ['INCLUDE'] = INCLUDE
os.environ['LIB'] = LIB