csharp
using System;
using System.Diagnostics;
using System.Windows.Forms;

namespace Flicker
{
    public partial class Form1 : Form
    {
        Stopwatch stopwatch = new Stopwatch();
        Timer timer = new Timer();

        public Form1()
        {
            InitializeComponent();

            stopwatch.Start();
            timer.Interval = 16; // 60 Hz
            timer.Tick += new EventHandler(UpdateFrame);
            timer.Start();
        }

        public void UpdateFrame(object sender, EventArgs e)
        {
            double cycleHz = 0.001;

            double wave = Math.Sin((stopwatch.ElapsedMilliseconds * 2.0 * Math.PI) * cycleHz);

            if (wave > 0.0)
            {
                pictureBox1.BackColor = System.Drawing.Color.Black;
            }
            else
            {
                pictureBox1.BackColor = System.Drawing.Color.White;
            }
        }

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}