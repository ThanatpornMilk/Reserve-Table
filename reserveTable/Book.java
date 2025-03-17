package reserveTable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book extends JFrame implements MouseListener, ActionListener, Finally, setComponent, Initial {
    Container cp;
    JLabel Book, Name, Phone, Size, Date, Time;
    JTextField t1, t2, t3;
    JButton b1, b2;
    JComboBox<String> c1, c2;
    JPanel p;

    public Book() {
        super("Book A Table");
        Initial();
        setComponent();
        BufferedImage pic;
        try {
            pic = ImageIO.read(new File("reserveTable/img/newreserve.jpg"));
            JLabel Ipic = new JLabel(new ImageIcon(pic));
            Ipic.setBounds(0, 0, 1000, 600);
            cp.add(Ipic);
        } catch (Exception e) {
            System.out.println(e);
        }
        Finally();
    }

    public void Initial() {
        cp = this.getContentPane();
        cp.setLayout(null);
    }

    public void setComponent() {
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(350, 80, 300, 410);
        p.setBackground(new Color(0, 0, 0, 150));

        Book = new JLabel("Book A Table");
        Book.setFont(new Font("Sitka Text", Font.BOLD, 25));
        Book.setForeground(Color.white);

        Name = new JLabel("Full name");
        Name.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Name.setForeground(Color.white);
        t1 = new JTextField(20);

        Phone = new JLabel("Phone");
        Phone.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Phone.setForeground(Color.white);
        t2 = new JTextField(20);

        Size = new JLabel("Party size");
        Size.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Size.setForeground(Color.white);
        t3 = new JTextField(20);

        //////////////////////////////// Date
        Date = new JLabel("Date");
        Date.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Date.setForeground(Color.white);
        c1 = new JComboBox<>();
        c1.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        c1.setBackground(Color.WHITE);

        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < 3; i++) {
            currentDate = calendar.getTime();
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            c1.addItem(sdf.format(currentDate));
        }

        c1.setBounds(50, 275, 90, 25);
        p.add(c1);
        ////////////////////////////////

        /////////////////////////////// Time
        Time = new JLabel("Time");
        Time.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        Time.setForeground(Color.white);
        c2 = new JComboBox<>();
        c2.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        c2.setBackground(Color.WHITE);
        c2.addItem("16:00");
        c2.addItem("17:00");
        c2.addItem("18:00");
        c2.addItem("19:00");
        c2.addItem("20:00");
        c2.setBounds(160, 275, 90, 25);
        p.add(c2);

        b1 = new JButton("Save");
        b1.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b1.setBackground(Color.WHITE);
        b2 = new JButton("Back");
        b2.setFont(new Font("Sitka Text", Font.PLAIN, 13));
        b2.setBackground(Color.WHITE);

        Book.setBounds(65, 40, 200, 40);
        Name.setBounds(50, 85, 100, 25);
        t1.setBounds(50, 110, 200, 25);
        Phone.setBounds(50, 140, 100, 25);
        t2.setBounds(50, 165, 200, 25);
        Size.setBounds(50, 195, 100, 25);
        t3.setBounds(50, 220, 200, 25);
        Date.setBounds(50, 250, 100, 25);
        Time.setBounds(160, 250, 100, 25);

        b1.setBounds(50, 315, 200, 25);
        b2.setBounds(50, 350, 200, 25);

        p.add(Book);
        p.add(Name);
        p.add(Phone);
        p.add(Size);
        p.add(Date);
        p.add(Time);
        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(b1);
        p.add(b2);
        cp.add(p);

        b1.setActionCommand("Save");
        b1.addActionListener(this);
        b2.setActionCommand("Back");
        b2.addActionListener(this);
    }

    public void Finally() {
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Save") {
            String name = t1.getText();
            String phone = t2.getText();
            String partySize = t3.getText();
            if (name.isEmpty() || phone.isEmpty() || partySize.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields.", "ข้อมูลไม่ครบ",
                        JOptionPane.WARNING_MESSAGE);
            } else if (phone.matches("\\d+") && phone.length() >= 10) {
                table table = new table(name, phone, partySize, (String) c1.getSelectedItem(),
                        (String) c2.getSelectedItem());
                table.setVisible(true);
                dispose();
            }
        } else if (e.getActionCommand() == "Back") {
            Login Login = new Login();
            Login.setVisible(true);
            dispose();
        }
    }
}