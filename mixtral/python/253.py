!echo YOUR_ENVIRONMENT_VARIABLE={YOUR_SECRET} >> /root/.bashrc
%reload_ext google.colab
from google.colab import output
output.eval('!source ~/.bashrc')

# Example for repeating with other variables
!echo YOUR_SECOND_VARIABLE={YOUR_SECOND_SECRET} >> /root/.bashrc
output.eval('!source ~/.bashrc')

!echo YOUR_THIRD_VARIABLE={YOUR_THIRD_SECRET} >> /root/.bashrc
output.eval('!source ~/.bashrc')