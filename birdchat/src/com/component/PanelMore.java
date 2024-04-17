package com.component;

import com.app.MessageType;
import com.emoji.Emogi;
import com.emoji.ModelEmoji;
import com.event.PublicEvent;
import com.main.Main;
import com.raven.model.Model_Send_Message;
import com.raven.model.Model_User_Account;
import com.service.Service;
import com.swing.ScrollBar;
import com.swing.WrapLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;

public class PanelMore extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    private Model_User_Account user;

    public PanelMore() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonImage());
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader, "w 100%, h 30!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));    //  use warp layout
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        //  test color
        add(ch, "w 100%, h 100%");
    }

    private JButton getButtonImage() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/image.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
                ch.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory() || isImageFile(file);
                    }

                    @Override
                    public String getDescription() {
                        return "Image File";
                    }
                });
                int option = ch.showOpenDialog(Main.getFrames()[0]);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File files[] = ch.getSelectedFiles();
                    try {
                        for (File file : files) {
                            Model_Send_Message message = new Model_Send_Message(MessageType.IMAGE, Service.getInstance().getUser().getUserID(), user.getUserID(), "");
                            Service.getInstance().addFile(file, message);
                            PublicEvent.getInstance().getEventChat().sendMessage(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return cmd;
    }

    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                JFileChooser ch = new JFileChooser();
//                ch.showOpenDialog(Main.getFrames()[0]);
                //  Update next
//                    if (option == JFileChooser.APPROVE_OPTION) {
//                    File files[] = ch.getSelectedFiles();
//                    try {
//                        for (File file : files) {
//                            Model_Send_Message message = new Model_Send_Message(MessageType.FILE, Service.getInstance().getUser().getUserID(), user.getUserID(), "");
//                            Service.getInstance().addFile(file, message);
//                            PublicEvent.getInstance().getEventChat().sendMessage(message);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
                //
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
//                ch.setFileFilter(new FileFilter() {
//                    @Override
//                    public boolean accept(File file) {
//                        return file.isDirectory() || isImageFile(file);
//                    }
//
//                    @Override
//                    public String getDescription() {
//                        return "Image File";
//                    }
//                });
                int option = ch.showOpenDialog(Main.getFrames()[0]);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File files[] = ch.getSelectedFiles();
//                    File image = new File("D:/Projects/BirdChat/chart-application/src/com/raven/icon/file.png");
                    URL url = getClass().getResource("/com/raven/icon/file.png");
                    File image = new File(url.getPath());
                    try {
                        Model_Send_Message message1 = new Model_Send_Message(MessageType.IMAGE, Service.getInstance().getUser().getUserID(), user.getUserID(), "");
                        Service.getInstance().addFile(image, message1);
                        PublicEvent.getInstance().getEventChat().sendMessage(message1);
                        for (File file : files) {
                            Model_Send_Message message = new Model_Send_Message(MessageType.TEXT, Service.getInstance().getUser().getUserID(), user.getUserID(), file.getName()+"\n"+file.length() + " Byte");
                            Service.getInstance().addFile(file, message);
                            PublicEvent.getInstance().getEventChat().sendMessage(message);
                        }
                        
                       
                    
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    

                }
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle1() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (ModelEmoji d : Emogi.getInstance().getStyle1()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getEmojiStyle2() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emogi.getInstance().getImoji(21).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (ModelEmoji d : Emogi.getInstance().getStyle2()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButton(ModelEmoji data) {
        JButton cmd = new JButton(data.getIcon());
        cmd.setName(data.getId() + "");
        cmd.setBorder(new EmptyBorder(3, 3, 3, 3));
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Model_Send_Message message = new Model_Send_Message(MessageType.EMOJI, Service.getInstance().getUser().getUserID(), user.getUserID(), data.getId() + "");
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return cmd;
    }

    private void sendMessage(Model_Send_Message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearSelected() {
        for (Component c : panelHeader.getComponents()) {
            if (c instanceof OptionButton) {
                ((OptionButton) c).setSelected(false);
            }
        }
    }

    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }
    private JPanel panelHeader;
    private JPanel panelDetail;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
