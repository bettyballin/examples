Here is the complete executable code with the missing `IPList` class and necessary `using` directives:

csharp
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Http;
using System.Security.Principal;
using System.Configuration;

namespace Miscellaneous.Attributes.Controller
{
    public class IPList
    {
        private List<IPAddress> ipAddresses = new List<IPAddress>();
        private List<IPAddress> ipMasks = new List<IPAddress>();

        public void Add(string ip)
        {
            ipAddresses.Add(IPAddress.Parse(ip));
        }

        public void Add(string ip, string mask)
        {
            ipAddresses.Add(IPAddress.Parse(ip));
            ipMasks.Add(IPAddress.Parse(mask));
        }

        public bool CheckNumber(string userIpAddress)
        {
            IPAddress userIp = IPAddress.Parse(userIpAddress);
            for (int i = 0; i < ipAddresses.Count; i++)
            {
                if (ipMasks.Count <= i)
                {
                    if (ipAddresses[i].Equals(userIp))
                        return true;
                }
                else
                {
                    if (IsInRange(userIp, ipAddresses[i], ipMasks[i]))
                        return true;
                }
            }
            return false;
        }

        private bool IsInRange(IPAddress address, IPAddress range, IPAddress mask)
        {
            byte[] a = address.GetAddressBytes();
            byte[] r = range.GetAddressBytes();
            byte[] m = mask.GetAddressBytes();

            for (int i = 0; i < a.Length; i++)
            {
                if ((a[i] & m[i]) != (r[i] & m[i]))
                {
                    return false;
                }
            }
            return true;
        }
    }

    /// <summary>
    /// Filter by IP address
    /// </summary>
    public class FilterIPAttribute : AuthorizeAttribute
    {
        #region Allowed
        /// <summary>
        /// Comma seperated string of allowable IPs. Example "10.2.5.41,192.168.0.22"
        /// </summary>
        public string AllowedSingleIPs { get; set; }

        /// <summary>
        /// Comma seperated string of allowable IPs with masks. Example "10.2.0.0;255.255.0.0,10.3.0.0;255.255.0.0"
        /// </summary>
        public string AllowedMaskedIPs { get; set; }

        /// <summary>
        /// Gets or sets the configuration key for allowed single IPs
        /// </summary>
        public string ConfigurationKeyAllowedSingleIPs { get; set; }

        /// <summary>
        /// Gets or sets the configuration key allowed mmasked IPs
        /// </summary>
        public string ConfigurationKeyAllowedMaskedIPs { get; set; }

        /// <summary>
        /// List of allowed IPs
        /// </summary>
        IPList allowedIPListToCheck = new IPList();
        #endregion

        #region Denied
        /// <summary>
        /// Comma seperated string of denied IPs. Example "10.2.5.41,192.168.0.22"
        /// </summary>
        public string DeniedSingleIPs { get; set; }

        /// <summary>
        /// Comma seperated string of denied IPs with masks. Example "10.2.0.0;255.255.0.0,10.3.0.0;255.255.0.0"
        /// </summary>
        public string DeniedMaskedIPs { get; set; }

        /// <summary>
        /// Gets or sets the configuration key for denied single IPs
        /// </summary>
        public string ConfigurationKeyDeniedSingleIPs { get; set; }

        /// <summary>
        /// Gets or sets the configuration key for denied masked IPs
        /// </summary>
        public string ConfigurationKeyDeniedMaskedIPs { get; set; }

        /// <summary>
        /// List of denied IPs
        /// </summary>
        IPList deniedIPListToCheck = new IPList();
        #endregion

        /// <summary>
        /// Determines whether access to the core framework is authorized.
        /// </summary>
        /// <param name="actionContext">The HTTP context, which encapsulates all HTTP-specific information about an individual HTTP request.</param>
        /// <returns>
        /// true if access is authorized; otherwise, false.
        /// </returns>
        /// <exception cref="T:System.ArgumentNullException">The <paramref name="httpContext"/> parameter is null.</exception>
        protected override bool IsAuthorized(HttpActionContext actionContext)
        {
            if (actionContext == null)
                throw new ArgumentNullException("actionContext");

            string userIpAddress = ((HttpContextWrapper)actionContext.Request.Properties["MS_HttpContext"]).Request.UserHostName;

            try
            {
                // Check that the IP is allowed to access
                bool ipAllowed = CheckAllowedIPs(userIpAddress);

                // Check that the IP is not denied to access
                bool ipDenied = CheckDeniedIPs(userIpAddress);

                // Only allowed if allowed and not denied
                bool finallyAllowed = ipAllowed && !ipDenied;

                return finallyAllowed;
            }
            catch (Exception e)
            {
                // Log the exception, probably something wrong with the configuration
            }

            return true; // if there was an exception, then we return true
        }

        /// <summary>
        /// Checks the allowed IPs.
        /// </summary>
        /// <param name="userIpAddress">The user ip address.</param>
        /// <returns></returns>
        private bool CheckAllowedIPs(string userIpAddress)
        {
            // Populate the IPList with the Single IPs
            if (!string.IsNullOrEmpty(AllowedSingleIPs))
            {
                SplitAndAddSingleIPs(AllowedSingleIPs, allowedIPListToCheck);
            }

            // Populate the IPList with the Masked IPs
            if (!string.IsNullOrEmpty(AllowedMaskedIPs))
            {
                SplitAndAddMaskedIPs(AllowedMaskedIPs, allowedIPListToCheck);
            }

            // Check if there are more settings from the configuration (Web.config)
            if (!string.IsNullOrEmpty(ConfigurationKeyAllowedSingleIPs))
            {
                string configurationAllowedAdminSingleIPs = ConfigurationManager.AppSettings[ConfigurationKeyAllowedSingleIPs];
                if (!string.IsNullOrEmpty(configurationAllowedAdminSingleIPs))
                {
                    SplitAndAddSingleIPs(configurationAllowedAdminSingleIPs, allowedIPListToCheck);
                }
            }

            if (!string.IsNullOrEmpty(ConfigurationKeyAllowedMaskedIPs))
            {
                string configurationAllowedAdminMaskedIPs = ConfigurationManager.AppSettings[ConfigurationKeyAllowedMaskedIPs];
                if (!string.IsNullOrEmpty(configurationAllowedAdminMaskedIPs))
                {
                    SplitAndAddMaskedIPs(configurationAllowedAdminMaskedIPs, allowedIPListToCheck);
                }
            }

            return allowedIPListToCheck.CheckNumber(userIpAddress);
        }

        /// <summary>
        /// Checks the denied IPs.
        /// </summary>
        /// <param name="userIpAddress">The user ip address.</param>
        /// <returns></returns>
        private bool CheckDeniedIPs(string userIpAddress)
        {
            // Populate the IPList with the Single IPs
            if (!string.IsNullOrEmpty(DeniedSingleIPs))
            {
                SplitAndAddSingleIPs(DeniedSingleIPs, deniedIPListToCheck);
            }

            // Populate the IPList with the Masked IPs
            if (!string.IsNullOrEmpty(DeniedMaskedIPs))
            {
                SplitAndAddMaskedIPs(DeniedMaskedIPs, deniedIPListToCheck);
            }

            // Check if there are more settings from the configuration (Web.config)
            if (!string.IsNullOrEmpty(ConfigurationKeyDeniedSingleIPs))
            {
                string configurationDeniedAdminSingleIPs = ConfigurationManager.AppSettings[ConfigurationKeyDeniedSingleIPs];
                if (!string.IsNullOrEmpty(configurationDeniedAdminSingleIPs))
                {
                    SplitAndAddSingleIPs(configurationDeniedAdminSingleIPs, deniedIPListToCheck);
                }
            }

            if (!string.IsNullOrEmpty(ConfigurationKeyDeniedMaskedIPs))
            {
                string configurationDeniedAdminMaskedIPs = ConfigurationManager.AppSettings[ConfigurationKeyDeniedMaskedIPs];
                if (!string.IsNullOrEmpty(configurationDeniedAdminMaskedIPs))
                {
                    SplitAndAddMaskedIPs(configurationDeniedAdminMaskedIPs, deniedIPListToCheck);
                }
            }

            return deniedIPListToCheck.CheckNumber(userIpAddress);
        }

        /// <summary>
        /// Splits the incoming ip string of the format "IP,IP" example "10.2.0.0,10.3.0.0" and adds the result to the IPList
        /// </summary>
        /// <param name="ips">The ips.</param>
        /// <param name="list">The list.</param>
        private void SplitAndAddSingleIPs(string ips, IPList list)
        {
            var splitSingleIPs = ips.Split(',');
            foreach (string ip in splitSingleIPs)
                list.Add(ip);
        }

        /// <summary>
        /// Splits the incoming ip string of the format "IP;MASK,IP;MASK" example "10.2.0.0;255.255.0.0,10.3.0.0;255.255.0.0" and adds the result to the IPList
        /// </summary>
        /// <param name="ips">The ips.</param>
        /// <param name="list">The list.</param>
        private void SplitAndAddMaskedIPs(string ips, IPList list)
        {
            var splitMaskedIPs = ips.Split(',');
            foreach (string maskedIp in splitMaskedIPs)
            {
                var ipAndMask = maskedIp.Split(';');
                list.Add(ipAndMask[0], ipAndMask[1]); // IP;MASK
            }
        }

        public override void OnAuthorization(HttpActionContext actionContext)
        {
            base.OnAuthorization(actionContext);
        }
    }
}