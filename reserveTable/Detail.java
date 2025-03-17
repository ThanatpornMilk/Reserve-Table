package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Detail extends JFrame implements ActionListener, Finally, setComponent, Initial, Complete {
    Container cp;
    Container cp2;
    JLabel detail;
    JButton b1, b2;
    JPanel p;
    int Number = 0;
    String Name = "Test1";
    String Phone = "0962518548";
    String Time = "09:00";
    String Date = "01/01/2023";
    String Size = "1";

    public Detail() {
        super("Reservation Details");
        Initial();
        setComponent();
        Finally();
    }

    public Detail(int numberOfTable, String name, String phone, String size, String date, String time) {
        super("Reservation Details");
        this.Number = numberOfTable;
        this.Name = name;
        this.Phone = phone;
        this.Size = size;
        this.Time = time;
        this.Date = date;
        Initial();
        setComponent();

        Finally();
    }

    public void Complete() {
        JDialog Di = new JDialog();
        cp2 = Di.getContentPane();
        cp2.setLayout(new FlowLayout());
        JLabel c = new JLabel("บันทึกข้อมูลสำเร็จ.");
        c.setFont(new Font("Times New Roman", Font.BOLD, 15));
        cp2.add(c);
        Di.setVisible(true);
        Di.setLocationRelativeTo(null);
        Di.pack();
        dispose();
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 110, 300, 340);
        p.setBackground(new Color(0, 0, 0, 150));

        detail = new JLabel("Reservation Details");
        detail.setFont(new Font("Sitka Text", Font.BOLD, 20));
        detail.setForeground(Color.white);

        JLabel number = new JLabel("Table No. " + Number);
        number.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        number.setForeground(Color.white);

        JLabel name = new JLabel("Name : " + Name);
        name.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        name.setForeground(Color.white);

        JLabel phone = new JLabel("Phone : " + Phone);
        phone.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        phone.setForeground(Color.white);

        JLabel date = new JLabel("Date : " + Date);
        date.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        date.setForeground(Color.white);

        JLabel time = new JLabel("Time : " + Time);
        time.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        time.setForeground(Color.white);

        b1 = new JButton("Save");
        b1.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b1.setBackground(Color.WHITE);

        b2 = new JButton("Cancel Reservation");
        b2.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b2.setBackground(Color.WHITE);

        detail.setBounds(52, 40, 200, 40);
        number.setBounds(52, 90, 200, 25);
        name.setBounds(52, 120, 200, 25);
        phone.setBounds(52, 150, 200, 25);
        date.setBounds(52, 180, 200, 25);
        time.setBounds(52, 210, 200, 25);
        b1.setBounds(52, 240, 200, 35);
        b2.setBounds(52, 290, 200, 35);

        p.add(detail);
        p.add(number);
        p.add(name);
        p.add(phone);
        p.add(date);
        p.add(time);
        p.add(b1);
        p.add(b2);
        cp.add(p);
        b1.setActionCommand("save");
        b1.addActionListener(this);
        b2.setActionCommand("cancel");
        b2.addActionListener(this);
        BufferedImage pic;
        try {
            pic = ImageIO.read(new File("reserveTable/img/newreserve.jpg"));
            JLabel Ipic = new JLabel(new ImageIcon(pic));
            Ipic.setBounds(0, 0, 1000, 600);
            cp.add(Ipic);
        } catch (IOException e) {
        }
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void Finally() {
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "cancel") {
            Book book = new Book();
            book.setVisible(true);
            dispose();
        } else if (e.getActionCommand() == "save") {
            try {
                File f = new File("Reserved.txt");
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Name of table : " + Name + " ," + "\n" +
                        "     Phone of table : " + Phone + " ," + "\n" +
                        "     Size of table : " + Size + " ," + "\n" +
                        "     Date of table : " + Date + " ," + "\n" +
                        "     Time of table : " + Time + " ," + "\n" +
                        "     Number of table : " + Number + "\n");
                bw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            try {
                File f = new File("DayTable.txt");
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Date + " ," + Time + " ," + Number + "\n");
                bw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            dispose();
            Complete();
            ;
        }
    }

}
