/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.j2me.keystore.ui;

import org.netbeans.modules.j2me.keystore.KeyStoreRepository;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class AddKeystorePanel extends javax.swing.JPanel implements ActionListener, DocumentListener {

    private static final String HELP_ID = "org.netbeans.modules.j2me.keystore.ui.AddKeystorePanel"; //NOI18N
    static String location = System.getProperty("user.home", ""); // NOI18N
    private ErrorPanel errorPanel = new ErrorPanel();

    private DialogDescriptor dd;

    /**
     * Creates new form CreateKeystorePanel
     */
    public AddKeystorePanel() {
        initComponents();
        initAccessibility();
        rNew.addActionListener(this);
        rExisting.addActionListener(this);
        tName.getDocument().addDocumentListener(this);
        tLocation.getDocument().addDocumentListener(this);
        tPassword.getDocument().addDocumentListener(this);
        tPasswordConfirm.getDocument().addDocumentListener(this);
        tFile.getDocument().addDocumentListener(this);

        rNew.setSelected(true);
        tName.setText("keystore.ks"); // NOI18N
        tLocation.setText(location);
        tFile.setText(location);

        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(errorPanel, gridBagConstraints);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup = new javax.swing.ButtonGroup();
        rNew = new javax.swing.JRadioButton();
        lName = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        lLocation = new javax.swing.JLabel();
        tLocation = new javax.swing.JTextField();
        bBrowseLocation = new javax.swing.JButton();
        lPassword = new javax.swing.JLabel();
        tPassword = new javax.swing.JPasswordField();
        lPasswordConfirm = new javax.swing.JLabel();
        tPasswordConfirm = new javax.swing.JPasswordField();
        rExisting = new javax.swing.JRadioButton();
        lFile = new javax.swing.JLabel();
        tFile = new javax.swing.JTextField();
        bBrowseFile = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        setLayout(new java.awt.GridBagLayout());

        buttonGroup.add(rNew);
        rNew.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(rNew, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_CreateNew")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(rNew, gridBagConstraints);
        rNew.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_New")); // NOI18N

        lName.setLabelFor(tName);
        org.openide.awt.Mnemonics.setLocalizedText(lName, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_Name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 12, 5);
        add(lName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        add(tName, gridBagConstraints);
        tName.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Name")); // NOI18N

        lLocation.setLabelFor(tLocation);
        org.openide.awt.Mnemonics.setLocalizedText(lLocation, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_Folder")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 5);
        add(lLocation, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(tLocation, gridBagConstraints);
        tLocation.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Folder")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(bBrowseLocation, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_BrowseFolder")); // NOI18N
        bBrowseLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBrowseLocationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(bBrowseLocation, gridBagConstraints);
        bBrowseLocation.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Browse1")); // NOI18N

        lPassword.setLabelFor(tPassword);
        org.openide.awt.Mnemonics.setLocalizedText(lPassword, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_Password")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 16, 12, 5);
        add(lPassword, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 12, 0);
        add(tPassword, gridBagConstraints);
        tPassword.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Password")); // NOI18N

        lPasswordConfirm.setLabelFor(tPasswordConfirm);
        org.openide.awt.Mnemonics.setLocalizedText(lPasswordConfirm, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_ConfirmPassword")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 5);
        add(lPasswordConfirm, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        add(tPasswordConfirm, gridBagConstraints);
        tPasswordConfirm.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Password2")); // NOI18N

        buttonGroup.add(rExisting);
        org.openide.awt.Mnemonics.setLocalizedText(rExisting, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_AddExisting")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 12, 0);
        add(rExisting, gridBagConstraints);
        rExisting.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Existing")); // NOI18N

        lFile.setLabelFor(tFile);
        org.openide.awt.Mnemonics.setLocalizedText(lFile, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_File")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 5);
        add(lFile, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(tFile, gridBagConstraints);
        tFile.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Keystore")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(bBrowseFile, org.openide.util.NbBundle.getMessage(AddKeystorePanel.class, "LBL_AddKeystore_BrowseFile")); // NOI18N
        bBrowseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBrowseFileActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(bBrowseFile, gridBagConstraints);
        bBrowseFile.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore_Browse2")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void initAccessibility() {
        getAccessibleContext().setAccessibleName(NbBundle.getMessage(AddKeystorePanel.class, "ACSN_AddKeystore"));
        getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddKeystorePanel.class, "ACSD_AddKeystore"));
    }

    protected void setDialogDescriptor(final DialogDescriptor desc) {
        this.dd = desc;
        dd.setHelpCtx(new HelpCtx(HELP_ID));
        actionPerformed(null);
    }

    public String getErrorMessage() {
        File file;
        if (rNew.isSelected()) {
            final String text = tName.getText();
            if (text == null || "".equals(text)) // NOI18N
            {
                return "ERR_EmptyKSFileName"; // NOI18N
            }            // Fix for #201484 - The keystore manager should not allow to use special characters in the keystore name
            if (tName.getText().contains("\\") || tName.getText().contains("/") // NOI18N 
                    || tName.getText().contains("<") || tName.getText().contains(">") // NOI18N 
                    || tName.getText().contains(":") || tName.getText().contains("|") // NOI18N 
                    || tName.getText().contains("\"")) { // NOI18N 
                return "ERR_KSInvalidFile"; // NOI18N 
            }
            file = new File(tLocation.getText());
            if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                return "ERR_KSFolderNotExists"; // NOI18N
            }
            file = new File(file, text);
            if (file.exists()) {
                return "ERR_KSFileExists"; // NOI18N
            }            // Fix for #162574 - Keystore Name should be checked for correctness
            try {
                file.getCanonicalPath();
            } catch (IOException e) {
                return "ERR_KSInvalidFile"; // NOI18N
            }
            if (KeyStoreRepository.getDefault().getKeyStore(file.getAbsolutePath(), false) != null) {
                return "ERR_KSFileAlreadyAdded"; // NOI18N
            }
            if (tPassword.getPassword().length < 6) {
                return "ERR_PasswordSmall"; // NOI18N
            }
            if (!new String(tPassword.getPassword()).equals(new String(tPasswordConfirm.getPassword()))) {
                return "ERR_PasswordsNotEqual"; // NOI18N
            }
        } else {
            file = new File(tFile.getText());
            if (!file.exists() || !file.isFile()) {
                return "ERR_KSFileNotExists"; // NOI18N
            }
        }
        return null;
    }

    public void checkErrors() {
        final String errorMessage = getErrorMessage();
        errorPanel.setErrorMessage(errorMessage != null ? NbBundle.getMessage(AddKeystorePanel.class, errorMessage) : null);
        final boolean valid = errorMessage == null;
        if (dd != null && valid != dd.isValid()) {
            dd.setValid(valid);
        }
    }

    @Override
    public void actionPerformed(@SuppressWarnings("unused")
            final ActionEvent e) {
        final boolean selected = rNew.isSelected();
        lName.setEnabled(selected);
        tName.setEnabled(selected);
        lLocation.setEnabled(selected);
        tLocation.setEnabled(selected);
        bBrowseLocation.setEnabled(selected);
        lPassword.setEnabled(selected);
        tPassword.setEnabled(selected);
        lPasswordConfirm.setEnabled(selected);
        tPasswordConfirm.setEnabled(selected);
        lFile.setEnabled(!selected);
        tFile.setEnabled(!selected);
        bBrowseFile.setEnabled(!selected);

        checkErrors();
    }

    @Override
    public void changedUpdate(@SuppressWarnings("unused")
            final DocumentEvent e) {
        checkErrors();
    }

    @Override
    public void insertUpdate(@SuppressWarnings("unused")
            final DocumentEvent e) {
        checkErrors();
    }

    @Override
    public void removeUpdate(@SuppressWarnings("unused")
            final DocumentEvent e) {
        checkErrors();
    }

    private void bBrowseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBrowseFileActionPerformed
        final String file = Utils.browseFilter(this, tFile.getText(), NbBundle.getMessage(AddKeystorePanel.class, "TITLE_SelectKeystore"), JFileChooser.FILES_ONLY, new FileFilter() { // NOI18N
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                if (!f.isFile()) {
                    return false;
                }
                String name = f.getName();
                int i = name.lastIndexOf('.');
                if (i < 0) {
                    return false;
                }
                name = name.substring(i).toLowerCase();
                return ".ks".equals(name) || ".keystore".equals(name) || ".p12".equals(name) || ".pkcs12".equals(name) || ".jks".equals(name); // NOI18N
            }

            @Override
            public String getDescription() {
                return NbBundle.getMessage(AddKeystorePanel.class, "LBL_KeystoreFileFilter"); // NOI18N
            }

        });
        if (file == null) {
            return;
        }
        File f = new File(file);
        f = f.getParentFile();
        if (f != null) {
            location = f.getAbsolutePath();
        } else {
            location = file;
        }
        tFile.setText(file);
    }//GEN-LAST:event_bBrowseFileActionPerformed

    private void bBrowseLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBrowseLocationActionPerformed
        final String folder = Utils.browseFolder(this, tLocation.getText(), NbBundle.getMessage(AddKeystorePanel.class, "TITLE_SelectKeystoresFolder")); // NOI18N
        if (folder == null) {
            return;
        }
        tLocation.setText(location = folder);
    }//GEN-LAST:event_bBrowseLocationActionPerformed

    public static KeyStoreRepository.KeyStoreBean showAddKeystorePanel() {
        final AddKeystorePanel add = new AddKeystorePanel();
        final DialogDescriptor dd = new DialogDescriptor(add, NbBundle.getMessage(AddKeystorePanel.class, "TITLE_AddKeystore"), true, null); // NOI18N
        add.setDialogDescriptor(dd);
        add.checkErrors();
        final Dialog d = DialogDisplayer.getDefault().createDialog(dd);
        d.setVisible(true);
        if (dd.getValue() != NotifyDescriptor.OK_OPTION) {
            return null;
        }
        KeyStoreRepository.KeyStoreBean bean;
        if (add.rNew.isSelected()) {
            String file = add.tLocation.getText().trim() + File.separator + add.tName.getText().trim();
            if (!file.endsWith(".ks") && !file.endsWith(".keystore")) // NOI18N
            {
                file += ".ks"; // NOI18N
            }
            bean = KeyStoreRepository.getDefault().getKeyStore(file, false);
            if (bean == null) {
                bean = KeyStoreRepository.KeyStoreBean.create(file, new String(add.tPassword.getPassword()));
                bean.openKeyStore(true);
                KeyStoreRepository.getDefault().addKeyStore(bean);
            }
        } else {
            String file = add.tFile.getText().trim();
            bean = KeyStoreRepository.getDefault().getKeyStore(file, true);
        }
        return bean;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBrowseFile;
    private javax.swing.JButton bBrowseLocation;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel lFile;
    private javax.swing.JLabel lLocation;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lPasswordConfirm;
    private javax.swing.JRadioButton rExisting;
    private javax.swing.JRadioButton rNew;
    private javax.swing.JTextField tFile;
    private javax.swing.JTextField tLocation;
    private javax.swing.JTextField tName;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JPasswordField tPasswordConfirm;
    // End of variables declaration//GEN-END:variables

    static class Utils {

        public static String browseFolder(final JComponent parent, final String oldValue, final String title) {
            return browseFilter(parent, oldValue, title, JFileChooser.DIRECTORIES_ONLY, new FileFilter() {
                public boolean accept(File f) {
                    return f.exists() && f.canRead() && f.isDirectory();
                }

                public String getDescription() {
                    return NbBundle.getMessage(AddKeystorePanel.class, "LBL_Utils_FolderFilter"); // NOI18N
                }
            });
        }

        public static String browseFilter(final JComponent parent, final String oldValue, final String title, final int fileSelection, final FileFilter filter) {
            final JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(fileSelection);
            chooser.setFileFilter(filter);
            if (oldValue != null) {
                chooser.setSelectedFile(new File(oldValue));
            }
            chooser.setDialogTitle(title);
            if (chooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
                return chooser.getSelectedFile().getAbsolutePath();
            }
            return null;
        }
    }
}
