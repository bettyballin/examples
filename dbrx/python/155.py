import win32api
import win32print
import win32con

def on_print_job(job_id, level, job_info):
    # Filter .txt files only
    if not job_info['pDocument'].endswith('.txt'):
        return
    
    print(f"Cancelling print job {job_id} for file: {job_info['pDocument']}")
    
    try:
        win32print.SetJob(job_info['hPrinter'], job_id, 0, None, win32con.JOB_CONTROL_CANCEL)
        
    except Exception as e:
        print(f"Error cancelling print job: {e}")

# Set up the printer change notification
change_filter = [
    (win32print.PRINTER_CHANGE_JOB_NOTIFY_TYPE, win32print.PRINTER_CHANGE_ADD_JOB)]

hprinter = win32print.OpenPrinter(win32print.GetDefaultPrinter())
notification_handle = win32print.FindFirstPrinterChangeNotification(hprinter, 0, *change_filter)

# Monitor print jobs in a loop
while True:
    result = win32api.WaitForSingleObject(notification_handle, 1000)
    
    if result == win32con.WAIT_OBJECT_0:
        job_info_list = []
        
        while True:
            try:
                job_info = win32print.GetJob(hprinter, -1, win32print.JOB_INFO_2)
                
            except Exception as e:
                print(f"Error getting printer jobs: {e}")
                break
            
            if not job_info or len(job_info_list) >= 10:
                # Limit the number of monitored jobs
                break

            job_info_list.append(job_info)

        for job_id, level, job_info in win32print.EnumJobs(hprinter, -1, -1, win32print.JOB_INFO_2):
            on_print_job(job_id, level, job_info)
            
    elif result == win32con.WAIT_TIMEOUT:
        pass

    else:  # WAIT_FAILED
        print("Wait failed")
        break
        
# Clean up resources
win32api.FindCloseChangeNotification(notification_handle)
win32print.ClosePrinter(hprinter)