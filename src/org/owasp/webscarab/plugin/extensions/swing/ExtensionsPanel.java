/*
 * ExtensionsPanel.java
 *
 * Created on 05 December 2005, 08:41
 */

package org.owasp.webscarab.plugin.extensions.swing;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.tree.TreePath;
import org.owasp.webscarab.model.HttpUrl;
import org.owasp.webscarab.model.Preferences;
import org.owasp.webscarab.plugin.extensions.Extensions;
import org.owasp.webscarab.plugin.extensions.ExtensionsModel;
import org.owasp.webscarab.ui.swing.ColumnWidthTracker;
import org.owasp.webscarab.ui.swing.ConversationTableModel;
import org.owasp.webscarab.ui.swing.DateRenderer;
import org.owasp.webscarab.ui.swing.SwingPluginUI;
import org.owasp.webscarab.ui.swing.UrlTreeModelAdapter;
import org.owasp.webscarab.ui.swing.UrlTreeRenderer;
import org.owasp.webscarab.util.swing.ColumnDataModel;
import org.owasp.webscarab.util.swing.SwingWorker;
import org.owasp.webscarab.util.swing.TableSorter;

/**
 *
 * @author  rdawes
 */
public class ExtensionsPanel extends javax.swing.JPanel implements SwingPluginUI {
    
    private Extensions _extensions;
    private ExtensionsModel _model;
    
    private Logger _logger = Logger.getLogger(getClass().getName());
    
    /** Creates new form ExtensionsPanel */
    public ExtensionsPanel(Extensions extensions) {
        _extensions = extensions;
        _model = extensions.getModel();
        initComponents();
        urlTree.setModel(new UrlTreeModelAdapter(_model.getUrlModel()));
        urlTree.setRootVisible(false);
        urlTree.setShowsRootHandles(true);
        urlTree.setCellRenderer(new UrlTreeRenderer());
        
        TableModel tm = new ConversationTableModel(_model.getConversationModel());
        TableSorter ts = new TableSorter(tm, conversationTable.getTableHeader());
        conversationTable.setModel(ts);
        ColumnWidthTracker.getTracker("ConversationTable").addTable(conversationTable);
        conversationTable.setDefaultRenderer(Date.class, new DateRenderer());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        editDialog = new javax.swing.JDialog();
        tabbedPane = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        fileTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        directoryTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        loadButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        urlTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        conversationTable = new javax.swing.JTable();
        controlPanel = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();

        editDialog.setTitle("Extensions");
        editDialog.setModal(true);
        tabbedPane.setMinimumSize(new java.awt.Dimension(200, 200));
        tabbedPane.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane4.setViewportView(fileTextArea);

        tabbedPane.addTab("File", jScrollPane4);

        jScrollPane3.setViewportView(directoryTextArea);

        tabbedPane.addTab("Directory", jScrollPane3);

        editDialog.getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        jPanel3.add(loadButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel3.add(cancelButton);

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel3.add(okButton);

        editDialog.getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.5);
        jScrollPane1.setViewportView(urlTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        conversationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        conversationTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(conversationTable);

        jSplitPane1.setRightComponent(jScrollPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        controlPanel.setLayout(new java.awt.GridBagLayout());

        editButton.setText("Edit Extensions");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        controlPanel.add(editButton, gridBagConstraints);

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        controlPanel.add(checkButton, new java.awt.GridBagConstraints());

        add(controlPanel, java.awt.BorderLayout.SOUTH);

    }
    // </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        _extensions.setDirectoryExtensions(stringToArray(directoryTextArea.getText()));
        _extensions.setFileExtensions(stringToArray(fileTextArea.getText()));
        editDialog.hide();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        editDialog.hide();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        JFileChooser jfc = new JFileChooser(Preferences.getPreference("Extensions.DefaultDir"));
        jfc.setDialogTitle("Open extension file");
        int returnVal = jfc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File extFile = jfc.getSelectedFile();
            try {
                String extensions = arrayToString(_extensions.loadStrings(extFile));
                if (tabbedPane.getTitleAt(tabbedPane.getSelectedIndex()).equals("File")) {
                    fileTextArea.setText(extensions);
                } else {
                    directoryTextArea.setText(extensions);
                }
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, new String[] {"Error loading extensions: ", ioe.getMessage()}, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        Preferences.setPreference("Scripted.DefaultDir", jfc.getCurrentDirectory().getAbsolutePath());
    }//GEN-LAST:event_loadButtonActionPerformed

    private String arrayToString(String[] strings) {
        StringBuffer buff = new StringBuffer();
        if (strings == null) return "";
        for (int i=0; i<strings.length; i++) {
            buff.append(strings[i]).append("\n");
        }
        return buff.toString();
    }
    
    private String[] stringToArray(String string) {
        return string.split("\\n");
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        fileTextArea.setText(arrayToString(_extensions.getFileExtensions()));
        directoryTextArea.setText(arrayToString(_extensions.getDirectoryExtensions()));
        editDialog.show();
    }//GEN-LAST:event_editButtonActionPerformed
    
    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        String action = evt.getActionCommand();
        if (action.equals("Stop")) {
            _extensions.stopChecks();
            return;
        }
        final TreePath[] selection = urlTree.getSelectionPaths();
        if (selection == null || selection.length == 0) return;
        if (_extensions.isBusy()) {
            showBusyMessage();
            return;
        }
        final HttpUrl[] urls = new HttpUrl[selection.length];
        for (int i=0; i<selection.length; i++) {
            urls[i] = (HttpUrl) selection[i].getLastPathComponent();
        }
        checkButton.setText("Stop");
        new SwingWorker() {
            public Object construct() {
                try {
                    if (urls.length>1) {
                        _extensions.checkExtensionsFor(urls);
                    } else {
                        _extensions.checkExtensionsUnder(urls[0]);
                    }
                    return null;
                } catch (IOException ioe) {
                    return ioe;
                }
            }
            public void finished() {
                Object result = getValue();
                if (result != null && result instanceof Throwable) {
                    Throwable throwable = (Throwable) result;
                    _logger.warning("Caught a : " + throwable.toString());
                }
                checkButton.setText("Check");
            }
        }.start();
    }//GEN-LAST:event_checkButtonActionPerformed
            
    private void showBusyMessage() {
        _logger.warning("Plugin is still busy, please wait");
        // FIXME show a message dialog
    }
    public Action[] getConversationActions() {
        return null;
    }

    public ColumnDataModel[] getConversationColumns() {
        return null;
    }

    public javax.swing.JPanel getPanel() {
        return this;
    }

    public String getPluginName() {
        return _extensions.getPluginName();
    }

    public Action[] getUrlActions() {
        return null;
    }

    public ColumnDataModel[] getUrlColumns() {
        return null;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTable conversationTable;
    private javax.swing.JTextArea directoryTextArea;
    private javax.swing.JButton editButton;
    private javax.swing.JDialog editDialog;
    private javax.swing.JTextArea fileTextArea;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton okButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTree urlTree;
    // End of variables declaration//GEN-END:variables
    
}
