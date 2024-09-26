import win32print
import win32api
import os

def job_filter(job_id):
    hprinter = None

    try:
        # Open printer
        hprinter = win32print.OpenPrinter("Your Printer Name", flags=0)

        if not hprinter:
            raise Exception('Failed to open the specified printer')

        job_info = {}

        # Get print job information
        res, info = win32print.GetJob(hprinter[1], job_id, 2)

        if not res or 'pDevMode' in dir(info):
            raise Exception('Failed to get the specified printer')

        document_name = str(win32api.CharUpper(str(info['Document']))).strip()

        # Check file extension
        ext = os.path.splitext(document_name)

        if ext[1].upper() == '.TXT':
            return 0

    except Exception as e:
        print('Error occurred while filtering job:', str(e))

    finally:
        # Close printer
        if hprinter:
            win32print.ClosePrinter(hprinter[1])

    return -1