package viewextends;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author tekeu
 */

public class PanelDate extends javax.swing.JLayeredPane {

    private int month;
    private int year;
    

    public PanelDate(int month, int year) {
        initComponents();
        this.month = month;
        this.year = year;
        init();
    }
    private void init(){
        mon.astitle();
        tue.astitle();
        wed.astitle();
        thu.astitle();
        fri.astitle();
        sat.astitle();
        sun.astitle();
        setDate();
    }
    private void setDate(){
        Calendar calendar =Calendar.getInstance();
        calendar.set(calendar.YEAR, year);
        calendar.set(calendar.MONTH, month-1);
        calendar.set(calendar.DATE, 1);
        int startDay = calendar.get(calendar.DAY_OF_WEEK)-1;
        calendar.add(calendar.DATE, -startDay);
        ToDay today= getToDay();
        for(Component com:getComponents()){
            Cell cell=(Cell)com;
            if(!cell.istitle()){
                cell.setText(calendar.get(calendar.DATE)+ "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(calendar.MONTH) == month - 1);
                if(today.isToDay(new ToDay(calendar.get(calendar.DATE), calendar.get(calendar.MONTH) + 1, calendar.get(calendar.YEAR)))){
                    cell.setAsToDay();
                    
                }
                calendar.add(calendar.DATE, 1);
            }
        }
    }
    
    private ToDay getToDay(){
         Calendar calendar =Calendar.getInstance();
         calendar.setTime(new Date());
         return new ToDay(calendar.get(calendar.DATE), calendar.get(calendar.MONTH) + 1, calendar.get(calendar.YEAR));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new viewextends.Cell();
        mon = new viewextends.Cell();
        tue = new viewextends.Cell();
        wed = new viewextends.Cell();
        thu = new viewextends.Cell();
        fri = new viewextends.Cell();
        sat = new viewextends.Cell();
        cell8 = new viewextends.Cell();
        cell9 = new viewextends.Cell();
        cell10 = new viewextends.Cell();
        cell11 = new viewextends.Cell();
        cell12 = new viewextends.Cell();
        cell13 = new viewextends.Cell();
        cell14 = new viewextends.Cell();
        cell15 = new viewextends.Cell();
        cell16 = new viewextends.Cell();
        cell17 = new viewextends.Cell();
        cell18 = new viewextends.Cell();
        cell19 = new viewextends.Cell();
        cell20 = new viewextends.Cell();
        cell21 = new viewextends.Cell();
        cell22 = new viewextends.Cell();
        cell23 = new viewextends.Cell();
        cell24 = new viewextends.Cell();
        cell25 = new viewextends.Cell();
        cell26 = new viewextends.Cell();
        cell27 = new viewextends.Cell();
        cell28 = new viewextends.Cell();
        cell29 = new viewextends.Cell();
        cell30 = new viewextends.Cell();
        cell31 = new viewextends.Cell();
        cell32 = new viewextends.Cell();
        cell33 = new viewextends.Cell();
        cell34 = new viewextends.Cell();
        cell35 = new viewextends.Cell();
        cell36 = new viewextends.Cell();
        cell37 = new viewextends.Cell();
        cell38 = new viewextends.Cell();
        cell39 = new viewextends.Cell();
        cell40 = new viewextends.Cell();
        cell41 = new viewextends.Cell();
        cell42 = new viewextends.Cell();
        cell43 = new viewextends.Cell();
        cell44 = new viewextends.Cell();
        cell45 = new viewextends.Cell();
        cell46 = new viewextends.Cell();
        cell47 = new viewextends.Cell();
        cell48 = new viewextends.Cell();
        cell49 = new viewextends.Cell();

        setLayout(new java.awt.GridLayout(7, 7));

        sun.setForeground(new java.awt.Color(232, 17, 17));
        sun.setText("Dimanche");
        sun.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });
        add(sun);

        mon.setText("Lundi");
        mon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        add(mon);

        tue.setText("Mardi");
        tue.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(tue);

        wed.setText("Mercredi");
        wed.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(wed);

        thu.setText("Jeudi");
        thu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(thu);

        fri.setText("Vendredi");
        fri.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(fri);

        sat.setText("Samedi");
        sat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        sat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satActionPerformed(evt);
            }
        });
        add(sat);

        cell8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell8);

        cell9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell9);

        cell10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell10);

        cell11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell11);

        cell12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell12);

        cell13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell13);

        cell14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell14);

        cell15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell15);

        cell16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cell16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell16ActionPerformed(evt);
            }
        });
        add(cell16);

        cell17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cell17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cell17ActionPerformed(evt);
            }
        });
        add(cell17);

        cell18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell18);

        cell19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell19);

        cell20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell20);

        cell21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell21);

        cell22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell22);

        cell23.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell23);

        cell24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell24);

        cell25.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell25);

        cell26.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell26);

        cell27.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell27);

        cell28.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell28);

        cell29.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell29);

        cell30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell30);

        cell31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell31);

        cell32.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell32);

        cell33.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell33);

        cell34.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell34);

        cell35.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell35);

        cell36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell36);

        cell37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell37);

        cell38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell38);

        cell39.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell39);

        cell40.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell40);

        cell41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell41);

        cell42.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell42);

        cell43.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell43);

        cell44.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell44);

        cell45.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell45);

        cell46.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell46);

        cell47.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell47);

        cell48.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell48);

        cell49.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        add(cell49);
    }// </editor-fold>//GEN-END:initComponents

    private void sunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sunActionPerformed

    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monActionPerformed

    private void satActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satActionPerformed

    private void cell16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cell16ActionPerformed

    private void cell17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cell17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cell17ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private viewextends.Cell cell10;
    private viewextends.Cell cell11;
    private viewextends.Cell cell12;
    private viewextends.Cell cell13;
    private viewextends.Cell cell14;
    private viewextends.Cell cell15;
    private viewextends.Cell cell16;
    private viewextends.Cell cell17;
    private viewextends.Cell cell18;
    private viewextends.Cell cell19;
    private viewextends.Cell cell20;
    private viewextends.Cell cell21;
    private viewextends.Cell cell22;
    private viewextends.Cell cell23;
    private viewextends.Cell cell24;
    private viewextends.Cell cell25;
    private viewextends.Cell cell26;
    private viewextends.Cell cell27;
    private viewextends.Cell cell28;
    private viewextends.Cell cell29;
    private viewextends.Cell cell30;
    private viewextends.Cell cell31;
    private viewextends.Cell cell32;
    private viewextends.Cell cell33;
    private viewextends.Cell cell34;
    private viewextends.Cell cell35;
    private viewextends.Cell cell36;
    private viewextends.Cell cell37;
    private viewextends.Cell cell38;
    private viewextends.Cell cell39;
    private viewextends.Cell cell40;
    private viewextends.Cell cell41;
    private viewextends.Cell cell42;
    private viewextends.Cell cell43;
    private viewextends.Cell cell44;
    private viewextends.Cell cell45;
    private viewextends.Cell cell46;
    private viewextends.Cell cell47;
    private viewextends.Cell cell48;
    private viewextends.Cell cell49;
    private viewextends.Cell cell8;
    private viewextends.Cell cell9;
    private viewextends.Cell fri;
    private viewextends.Cell mon;
    private viewextends.Cell sat;
    private viewextends.Cell sun;
    private viewextends.Cell thu;
    private viewextends.Cell tue;
    private viewextends.Cell wed;
    // End of variables declaration//GEN-END:variables
}
