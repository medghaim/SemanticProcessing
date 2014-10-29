/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IgnoreWordsWindow.java
 *
 * Created on Nov 21, 2010, 1:15:19 PM
 */
package semanticprocessing;

/**
 * The Ignore Words window to show when prompted for.
 * @author Moody
 */
public class IgnoreWordsWindow extends javax.swing.JFrame {
    public String savedText;
    private String wordsToIgnore;

    /** Creates new form IgnoreWordsWindow */
    public IgnoreWordsWindow() {
        initComponents();
        ignoredWordsTA.setText(savedText);
    }

    /**
     * A constructor to create an instance of this GUI, with the ignored words
     * retrieved from the save file.
     * @param textFromFile The previously saved list of ignored words that is
     * to be opened with
     */
    public IgnoreWordsWindow(String igWords) {
        initComponents();
        savedText = igWords;
        ignoredWordsTA.setText(savedText);
    }

    /** AND SO BEGINS THE AUTO-GENERATED CODE *********** */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ignoredWordsTA = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ignoredWordsTA.setColumns(20);
        ignoredWordsTA.setRows(5);
        jScrollPane1.setViewportView(ignoredWordsTA);

        jLabel1.setText("Please enter every word to ignore, on a separate line:");

        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /** END OF NETBEANS CODE **************************** */

    private void saveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseReleased
        savedText = ignoredWordsTA.getText();
        wordsToIgnore = savedText.replaceAll("\\n", " ");
        this.dispose();
    }//GEN-LAST:event_saveButtonMouseReleased

    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        ignoredWordsTA.setText(savedText);
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseReleased

    /**
     * The main function.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new IgnoreWordsWindow().setVisible(true);
            }
        });
    }
    //GENERATED VARIABLE DECLARATION
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea ignoredWordsTA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
    //END OF GENERATED VARIABLE DECLARATION

    /**
     * Returns a String of the ignored words entered by the user.
     * @return An String of ignored words as indicated by user.
     */
    public String getIgnoredWords() {
        return this.wordsToIgnore;
    }
}
