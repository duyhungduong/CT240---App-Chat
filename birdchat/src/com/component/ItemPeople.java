package com.component;

import com.event.PublicEvent;
import com.raven.model.Model_User_Account;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemPeople extends javax.swing.JPanel {

    public Model_User_Account getUser() {
        return user;
    }
    private boolean mouseOver;
    private final Model_User_Account user;

    public ItemPeople(Model_User_Account user) {
        this.user = user;
        initComponents();
        lb.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
    }

    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
//        if (user.isStatus()) {
//            lbStatus.setText("");
//        } else
//            lbStatus.setText("");
    }

    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(230, 230, 230));
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(new Color(242, 242, 242));
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (mouseOver) {
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.swing.ImageAvatar();
        lb = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new com.swing.ActiveStatus();

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-bird-80.png"))); // NOI18N

        lb.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lb.setText("Name");

        lbStatus.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(117, 117, 117));
        lbStatus.setText("Bạn bè");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbStatus)
                        .addGap(3, 3, 3)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        this.updateStatus();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        this.updateStatus();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.ActiveStatus activeStatus;
    private com.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}
