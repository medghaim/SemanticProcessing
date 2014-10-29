/*
 * GUIDesign.java
 *
 * Created on Oct 27, 2010, 1:34:36 PM
 */
package semanticprocessing;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 * The GUI controller of the program.
 * @author Moody
 */
public class GUI2 extends javax.swing.JFrame {

    /** The header for the column of the URL Table. */
    final private String[] urlHeader = {"URL"};
    /** The model that controls the URLs table. */
    private DefaultTableModel urlModel = new DefaultTableModel(null,
            urlHeader);
    /** The headers for the columns of the Results table. */
    final private String[] resultHeaders = {"URL", "% Relevancy"};
    /** The model that controls the Results table. */
    private DefaultTableModel resultModel = new DefaultTableModel(null,
            resultHeaders);
    /** The current Search object. */
    private Search search;
    /** The window that controls the upkeep of the ignored words. */
    private IgnoreWordsWindow igWin;
    private ArrayList<URL> urls;
    private Cache cache;

    /** Creates the GUI form and initializes its child UI.*/
    public GUI2() {
        setTitle("Semantic Processing");
        initComponents();
        igWin = new IgnoreWordsWindow();
        urls = new ArrayList<URL>();
        //TODO : ADD IF STATEMENT TO TEST FOR IF THERE IS A FILE -
        // Create a file, and .getAbsoluteFilePath() will return the entirety
        // of the file. Thus, we change the file name, and know what to test
        // for.  I'll do this tomorrow -  For now:
        cache = new Cache();
        search = new Search(cache, "", "");
        // This ensures the user is prompted to store search before closing.
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    }

    private void UpdateResultsTable() {
        resultModel = new DefaultTableModel(null, resultHeaders);
        for (Result res : search.getResults()) {
            Object[] rowData = {res.getPage().getMainURL(), res.getScore()};
            resultModel.addRow(rowData);
        }
        listOfResults.setModel(resultModel);
    }

    /** AND SO BEGINS THE AUTO-GENERATED CODE *********** */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        URLTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOfURLs = new javax.swing.JTable();
        urlTextField = new javax.swing.JTextField();
        addURLButton = new javax.swing.JButton();
        selectAllButton = new javax.swing.JButton();
        deleteFromList = new javax.swing.JButton();
        importURLsButton = new javax.swing.JButton();
        enterParagraph = new javax.swing.JButton();
        searchTab = new javax.swing.JPanel();
        searchLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        probStateTextArea = new javax.swing.JTextArea();
        ignoreWordsBox = new javax.swing.JCheckBox();
        searchURLsButton = new javax.swing.JButton();
        importSearchButton = new javax.swing.JButton();
        editIgWords = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultTab = new javax.swing.JPanel();
        searchInfoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfResults = new javax.swing.JTable();
        hideSelectedButton = new javax.swing.JButton();
        showHiddenButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newSearchMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        exitOptionMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        openHelpMenuItem = new javax.swing.JMenuItem();

        jTabbedPane4.addTab("tab1", jTabbedPane5);

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        listOfURLs.setModel(urlModel);
        jScrollPane1.setViewportView(listOfURLs);

        urlTextField.setText("http://");
        urlTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                urlTextFieldKeyPressed(evt);
            }
        });

        addURLButton.setText("Add URL to List");
        addURLButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addURLButtonMouseReleased(evt);
            }
        });

        selectAllButton.setText("Select All");
        selectAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                selectAllButtonMouseReleased(evt);
            }
        });

        deleteFromList.setText("Delete from List");
        deleteFromList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteFromListMouseReleased(evt);
            }
        });

        importURLsButton.setText("Import URLs from File...");
        importURLsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                importURLsButtonMouseReleased(evt);
            }
        });

        enterParagraph.setText("Enter Paragraph");
        enterParagraph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                enterParagraphMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout URLTabLayout = new javax.swing.GroupLayout(URLTab);
        URLTab.setLayout(URLTabLayout);
        URLTabLayout.setHorizontalGroup(
            URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(URLTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(URLTabLayout.createSequentialGroup()
                        .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, URLTabLayout.createSequentialGroup()
                                .addComponent(urlTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addURLButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, URLTabLayout.createSequentialGroup()
                                .addComponent(selectAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addGap(126, 126, 126)
                                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterParagraph, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(URLTabLayout.createSequentialGroup()
                                        .addGap(153, 153, 153)
                                        .addComponent(importURLsButton)))))
                        .addContainerGap())
                    .addGroup(URLTabLayout.createSequentialGroup()
                        .addComponent(deleteFromList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(471, 471, 471))))
        );
        URLTabLayout.setVerticalGroup(
            URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(URLTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addURLButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importURLsButton)
                    .addComponent(selectAllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(URLTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteFromList)
                    .addComponent(enterParagraph))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Enter URLs", URLTab);

        searchLabel.setText("Copy out your problem statement in the follow area, or import from file:");

        probStateTextArea.setColumns(20);
        probStateTextArea.setFont(new java.awt.Font("Arial", 0, 13));
        probStateTextArea.setLineWrap(true);
        probStateTextArea.setRows(5);
        jScrollPane2.setViewportView(probStateTextArea);

        ignoreWordsBox.setText("Use Ignore Words");
        ignoreWordsBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ignoreWordsBoxMouseReleased(evt);
            }
        });

        searchURLsButton.setText("Search URLs");
        searchURLsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchURLsButtonMouseReleased(evt);
            }
        });

        importSearchButton.setText("Import from File...");
        importSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                importSearchButtonMouseReleased(evt);
            }
        });

        editIgWords.setText("Edit Ignore Words");
        editIgWords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editIgWordsMouseReleased(evt);
            }
        });

        jLabel1.setText("CTRL-Click to Open results in a new window:");

        javax.swing.GroupLayout searchTabLayout = new javax.swing.GroupLayout(searchTab);
        searchTab.setLayout(searchTabLayout);
        searchTabLayout.setHorizontalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchTabLayout.createSequentialGroup()
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(searchTabLayout.createSequentialGroup()
                                .addComponent(ignoreWordsBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editIgWords)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE))
                            .addGroup(searchTabLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchURLsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importSearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        searchTabLayout.setVerticalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importSearchButton)
                    .addComponent(ignoreWordsBox)
                    .addComponent(editIgWords))
                .addGap(23, 23, 23)
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchURLsButton)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Searching", searchTab);

        searchInfoLabel.setText("A search of the cache of URL's yielded the following results of professors:");

        listOfResults.setModel(resultModel);
        jScrollPane3.setViewportView(listOfResults);

        hideSelectedButton.setText("Hide Selected");
        hideSelectedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                hideSelectedButtonMouseReleased(evt);
            }
        });

        showHiddenButton.setText("Show Hidden");
        showHiddenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showHiddenButtonMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout resultTabLayout = new javax.swing.GroupLayout(resultTab);
        resultTab.setLayout(resultTabLayout);
        resultTabLayout.setHorizontalGroup(
            resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchInfoLabel)
                    .addGroup(resultTabLayout.createSequentialGroup()
                        .addComponent(hideSelectedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showHiddenButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
                .addContainerGap())
        );
        resultTabLayout.setVerticalGroup(
            resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(resultTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hideSelectedButton)
                    .addComponent(showHiddenButton))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Results", resultTab);

        fileMenu.setText("File");

        newSearchMenuItem.setText("New Search");
        newSearchMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newSearchMenuItemMouseReleased(evt);
            }
        });
        fileMenu.add(newSearchMenuItem);

        jMenuItem2.setText("Import Cache");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseReleased(evt);
            }
        });
        fileMenu.add(jMenuItem2);

        jMenuItem1.setText("Export Cache");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        exitOptionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitOptionMenuItem.setText("Exit");
        exitOptionMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitOptionMenuItemMouseReleased(evt);
            }
        });
        fileMenu.add(exitOptionMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        openHelpMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        openHelpMenuItem.setText("Open Help Menu");
        openHelpMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                openHelpMenuItemMousePressed(evt);
            }
        });
        helpMenu.add(openHelpMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** END OF NETBEANS CODE **************************** */
    /**
     * Allows the user to press Enter in order to enter his URL, as opposed to
     * clicking the "Add to URL List" button. Simple functionality.
     * @param evt The key event as defined by the user, the ENTER is retrieved
     * from this parameter.
     */
    private void urlTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTextFieldKeyPressed
        char key = evt.getKeyChar();
        if (key == KeyEvent.VK_ENTER) {
            enterURLToTable();
        }

    }//GEN-LAST:event_urlTextFieldKeyPressed

    /**
     * Functionality for Menu Bars. Opens the help file under Help.
     * @param evt The mouse event specified by the user.
     */
    private void openHelpMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openHelpMenuItemMousePressed
        try {
            // open the userguide.pdf
            Desktop d = java.awt.Desktop.getDesktop();
            d.open(new java.io.File("UserGuideWhole.pdf"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid directory", "ERROR",
                    0);
        }

    }//GEN-LAST:event_openHelpMenuItemMousePressed

    /**
     * The course of action taken by pressing "Import URLs from File..".
     * Will prompt the user with a JFileChooser to select the file that contains
     * a list of URLs to be read into the program.
     * @param evt The mouse event specified by the user.
     */
    private void importURLsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importURLsButtonMouseReleased
        JFileChooser file = new JFileChooser();
        int openFile = file.showOpenDialog(null);

        //PUTTING URLS IN urlTextField
        if (openFile == JFileChooser.APPROVE_OPTION) {
            File urlFile = file.getSelectedFile();
            try {
                ArrayList<URL> urlFileList = FileOps.readURLsFromFile(urlFile);
                for (URL url : urlFileList) {
                    addURL(url);

                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(URLTab, "Cannot read given file.",
                        "ERROR", 0);
            }

        }
    }//GEN-LAST:event_importURLsButtonMouseReleased
    /**
     * The course of action the be taken upon pressing "Add URL to List". It
     * will only be added if it is valid, and not already contained in the list.
     * @param evt The mouse event specified by the user.
     */
    private void addURLButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addURLButtonMouseReleased
        enterURLToTable();
    }//GEN-LAST:event_addURLButtonMouseReleased

    /**
     * The course of action to be taken upon pressing "Select All". This will
     * change the "Select" button back and from "Deselect" accordingly.
     * @param evt The mouse action specified by the user.
     */
    private void selectAllButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectAllButtonMouseReleased
        if (selectAllButton.getText().equals("Select All")) {
            listOfURLs.selectAll();
            selectAllButton.setText("Deselect All");
        } else {
            listOfURLs.clearSelection();
            selectAllButton.setText("Select All");
        }
    }//GEN-LAST:event_selectAllButtonMouseReleased

    /**
     * The course of action to be taken upon the pressing of "Delete from
     * List". Will delete all of the selected URLs.
     *  @param evt The user-entered action event.
     */
    private void deleteFromListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFromListMouseReleased
        int rowNums = listOfURLs.getSelectedRows().length;
        for (int i = 0; i < rowNums; i++) {
            int row = listOfURLs.getSelectedRow();
            URL url = (URL) urlModel.getValueAt(row, 0);
            urls.remove(url);
            cache.remove((URL) urlModel.getValueAt(row, 0));
            urlModel.removeRow(row);
        }
    }//GEN-LAST:event_deleteFromListMouseReleased

    /**
     * The course of action to be taken upon a the pressing of "Import Search"
     * button. Prompts the user with a JFileChooser to choose a file, and
     * copies text from the file, to the correct TextArea.
     *  @param evt The user-entered action event.
     */
    private void importSearchButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importSearchButtonMouseReleased
        JFileChooser file = new JFileChooser();
        int openFile = file.showOpenDialog(null);

        if (openFile == JFileChooser.APPROVE_OPTION) {
            File parFile = file.getSelectedFile();
            try {
                String newFile = FileOps.readFile(parFile);
                probStateTextArea.append(newFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "File does not Exist",
                        "ERROR", 0);
            }
        }
    }//GEN-LAST:event_importSearchButtonMouseReleased

    /**
     * The course of action to be taken upon checking the "Ignore Words"
     * check box. Opens a new window, IgnoreWordsWindow, that allows the user
     * to define the words they wish to ignore.
     * @param evt The user-entered action event.
     */
    private void ignoreWordsBoxMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ignoreWordsBoxMouseReleased
        if (ignoreWordsBox.isSelected()) {
            igWin.setVisible(true);
        } else {
            igWin.dispose();
        }
    }//GEN-LAST:event_ignoreWordsBoxMouseReleased

    /**
     * The course of action to be taken upon a the pressing of "Search URLs".
     * Creates a new search using the information available to the GUI: The list
     * of URLs, the Problem Statement.
     *  @param evt The user-entered action event.
     */
    private void searchURLsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchURLsButtonMouseReleased
        // Change cursor to waiting.
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        resultModel = new DefaultTableModel(null, resultHeaders);
        listOfResults.setModel(resultModel);
        String problem = probStateTextArea.getText();
        if (problem.replaceAll("\\s*|\n", "").equals("") || urls.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "The URL list is empty or "
                    + "the Problem statement is empty", "ERROR", 0);
        } else {
            // Get ignored words
            String ignored;
            if (ignoreWordsBox.isSelected()) {
                ignored = igWin.getIgnoredWords();
            } else {
                ignored = "";
            }
            // Search
            cache.generateCache();
            search = new Search(cache, problem, ignored);

            // Display results
            for (Result res : search.getResults()) {
                Object[] rowData = {res.getPage().getMainURL(), res.getScore()};
                resultModel.addRow(rowData);
            }
            //System.out.println("Cache pending: " + cache.getNumberOfPendingUrls()
            //+ " === cache read: " + cache.getCachedURLs().size());
            // Switch to search tab
            this.jTabbedPane1.setSelectedIndex(2);
        }
        // Return cursor to normal
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_searchURLsButtonMouseReleased

    private void editIgWordsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editIgWordsMouseReleased
        igWin.setVisible(true);
    }//GEN-LAST:event_editIgWordsMouseReleased

    /**
     * Occurs when import cache is pressed.
     * @param evt Event invoked by user.
     */
    /**
     * Occurs when exportCache is pressed.
     * @param evt Event invoked by user.
     */
    private void enterParagraphMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterParagraphMouseReleased
        this.jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_enterParagraphMouseReleased

    private void newSearchMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSearchMenuItemMouseReleased
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you "
                + "want to create a "
                + "new search? This will clear the paragraph and the results.",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            newSearch();
        }
    }//GEN-LAST:event_newSearchMenuItemMouseReleased

    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cache files, .cache", "cache");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try {
                search.cache = FileOps.loadCache(f);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File does not Exist",
                        "ERROR", 0);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unable to read file. "
                        + "Please make sure you have read access to the "
                        + "selected file.", "ERROR", 0);
            } catch (InvalidFileException ex) {
                JOptionPane.showMessageDialog(this, "The given file is not a "
                        + "valid cache file.", "ERROR", 0);
            }
        }
        updateURLTable();
    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        // Initialize JFile chooser.
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Cache files, .cache", "cache");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showSaveDialog(this);

        // If a file is selected, save to it
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // Get path. JFileChooser is bugged and doesn't return extension.
            String path = fileChooser.getSelectedFile().toString();
            if (!path.endsWith(".cache")) {
                path += ".cache";
            }
            File f = new File(path);

            // Save to file.
            try {
                FileOps.saveCache(search.cache, f);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unable to read file. "
                        + "Please make sure you have read access to the "
                        + "selected file.", "ERROR", 0);
            }
        }
    }//GEN-LAST:event_jMenuItem1MouseReleased

    /**
     * Hides the selected rows.
     * @param evt The event that triggered this action.
     */
    private void hideSelectedButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideSelectedButtonMouseReleased
        int rowNums = listOfResults.getSelectedRows().length;
        for (int i = 0; i < rowNums; i++) {
            resultModel.removeRow(listOfResults.getSelectedRow());
        }
    }//GEN-LAST:event_hideSelectedButtonMouseReleased

    private void showHiddenButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHiddenButtonMouseReleased
        UpdateResultsTable();
    }//GEN-LAST:event_showHiddenButtonMouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            ArrayList load = (ArrayList) FileOps.loadObject(new File("close.save"));

            if (load.size() == 5){
                urls = (ArrayList<URL>) load.get(0);
                igWin = new IgnoreWordsWindow((String) load.get(1));
                probStateTextArea.setText((String) load.get(2));
                cache = (Cache) load.get(3);
                search = (Search) load.get(4);
                updateURLTable();
                UpdateResultsTable();
            } 
        } catch (Exception ex){

        }
     // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exitMenu();
    }//GEN-LAST:event_formWindowClosing

    private void exitOptionMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitOptionMenuItemMouseReleased
        exitMenu();
    }//GEN-LAST:event_exitOptionMenuItemMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel URLTab;
    private javax.swing.JButton addURLButton;
    private javax.swing.JButton deleteFromList;
    private javax.swing.JButton editIgWords;
    private javax.swing.JButton enterParagraph;
    private javax.swing.JMenuItem exitOptionMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton hideSelectedButton;
    private javax.swing.JCheckBox ignoreWordsBox;
    private javax.swing.JButton importSearchButton;
    private javax.swing.JButton importURLsButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable listOfResults;
    private javax.swing.JTable listOfURLs;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newSearchMenuItem;
    private javax.swing.JMenuItem openHelpMenuItem;
    private javax.swing.JTextArea probStateTextArea;
    private javax.swing.JPanel resultTab;
    private javax.swing.JLabel searchInfoLabel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchTab;
    private javax.swing.JButton searchURLsButton;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JButton showHiddenButton;
    private javax.swing.JTextField urlTextField;
    // End of variables declaration//GEN-END:variables

    private void save() throws IOException {
        ArrayList save = new ArrayList();
        save.add(urls);
        save.add(igWin.getIgnoredWords());
        save.add(probStateTextArea.getText());
        save.add(cache);
        save.add(search);
        FileOps.saveObject(save, new File("close.save"));

    }


    /**
     *
     */
    private void exitMenu() {
        int response = JOptionPane.showConfirmDialog(null, "Would you like "
                + "to save your search?", "Save you're search?",
                JOptionPane.YES_NO_CANCEL_OPTION);
        switch (response) {
            case JOptionPane.YES_OPTION:
                try {
                    save();
                } catch (IOException ex) {

                }
                System.exit(0);
            case JOptionPane.NO_OPTION:
                File save = new File("save.close");
                save.delete();
                System.exit(0);

        }
    }

    /**
     *Try to add the URL into the URL table. If it is invalid, then displays
     * an error message.
     */
    private void enterURLToTable() {
        if (!urlTextField.getText().startsWith("http://")) {
            JOptionPane.showMessageDialog(URLTab,
                    "Please enter a valid URL.", "ERROR", 0);
            return;
        }
        try {

            // Validation
            URI uri = new URI(urlTextField.getText());
            URL url = new URL(urlTextField.getText());
            addURL(url);
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(URLTab,
                    "Please enter a valid URL.", "ERROR", 0);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(URLTab,
                    "Please enter a valid URL.", "ERROR", 0);
        } finally {
            urlTextField.setText("http://");
        }
    }

    /**
     * Returns true if the indicated URL is added to the cache, false if
     * already contained within the cache.
     * @return True if the URL is added successfully.
     * @param url The URL to be added to the cache.
     */
    private void addURL(final URL url) {
        if (!cache.add(url)) {
            JOptionPane.showMessageDialog(URLTab, url.toString()
                    + " has already been queued.", "ERROR", 0);
        } else {
            urls.add(url);
            urlModel.addRow(new Object[]{url});
        }
    }

    /**
     * Updates the URL table with the URLs in cache.
     */
    private void updateURLTable() {
        urlModel = new DefaultTableModel(null,
                urlHeader);
        for (URL url : search.cache.getCachedURLs()) {
            urlModel.addRow(new URL[]{url});
        }
        for (URL url : search.cache.getPendingURLs()) {
            urlModel.addRow(new URL[]{url});
        }
        listOfURLs.setModel(urlModel);
    }

    private void newSearch() {
        resultModel = new DefaultTableModel(null,
                resultHeaders);
        listOfResults.setModel(resultModel);
        probStateTextArea.setText("");
    }
}
