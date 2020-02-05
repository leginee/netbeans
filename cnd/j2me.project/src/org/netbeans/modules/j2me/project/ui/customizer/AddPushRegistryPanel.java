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

package org.netbeans.modules.j2me.project.ui.customizer;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import org.openide.DialogDescriptor;
import org.openide.util.HelpCtx;
import org.openide.util.Utilities;
import org.openide.util.NbBundle;

/**
 *
 */
public class AddPushRegistryPanel extends javax.swing.JPanel implements ActionListener, DocumentListener {
    
    private DialogDescriptor dd;
    
    /** Creates new form AddPushRegistryPanel */
    public AddPushRegistryPanel(ComboBoxModel model) {
        initComponents();
        initAccessibility();
        if (model != null)
            cClass.setModel(model);
        cClass.getEditor().addActionListener(this);
        Component comp = cClass.getEditor().getEditorComponent();
        if (comp instanceof JTextField)
            ((JTextField) comp).getDocument().addDocumentListener(this);
    }
    
    public AddPushRegistryPanel(ComboBoxModel model, String clazz, String sender, String string) {
        this(model);
        cClass.getEditor().setItem(clazz);
        tSender.setText(sender);
        tString.setText(string);
    }
    
    public String getClazz() {
        return (String) cClass.getEditor().getItem();
    }
    
    public String getSender() {
        return tSender.getText();
    }
    
    public String getString() {
        return tString.getText();
    }
    
    protected void setDialogDescriptor(final DialogDescriptor desc) {
        this.dd = desc;
        dd.setHelpCtx(new HelpCtx("org.netbeans.modules.j2me.project.ui.customizer.AddPushRegistryPanel")); //NOI18N
        actionPerformed(null);
    }
    
    private boolean isValidClassName(final String s) {
        if (s.startsWith(".")  ||  s.endsWith(".")) //NOI18N
            return false; //NOI18N
        final StringTokenizer stk = new StringTokenizer(s, "."); //NOI18N
        while (stk.hasMoreTokens())
            if (!Utilities.isJavaIdentifier(stk.nextToken()))
                return false;
        return true;
    }
    
    public boolean isStateValid() {
        if (getClazz().length() == 0  ||  !isValidClassName(getClazz())) {
            ((ErrorPanel) errorPanel).setErrorBundleMessage("ERR_AddPush_InvClass");//NOI18N
            return false;
        }
        ((ErrorPanel) errorPanel).setErrorBundleMessage(null);
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        cClass = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tSender = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tString = new javax.swing.JTextField();
        errorPanel = new ErrorPanel();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setLabelFor(cClass);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(AddPushRegistryPanel.class, "LBL_AddPush_Class")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 5);
        add(jLabel1, gridBagConstraints);
        jLabel1.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddPushRegistryPanel.class, "ACSD_AddRegistry_Class")); // NOI18N

        cClass.setEditable(true);
        cClass.setPreferredSize(new java.awt.Dimension(250, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 12);
        add(cClass, gridBagConstraints);

        jLabel2.setLabelFor(tSender);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(AddPushRegistryPanel.class, "LBL_AddPush_Sender")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 5);
        add(jLabel2, gridBagConstraints);
        jLabel2.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddPushRegistryPanel.class, "ACSD_AddRegistry_Sender")); // NOI18N

        tSender.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 12);
        add(tSender, gridBagConstraints);

        jLabel3.setLabelFor(tString);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(AddPushRegistryPanel.class, "LBL_AddPush_String")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 5);
        add(jLabel3, gridBagConstraints);
        jLabel3.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddPushRegistryPanel.class, "ACSD_AddRegistry_String")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 12);
        add(tString, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(errorPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    private void initAccessibility() {
        getAccessibleContext().setAccessibleName(NbBundle.getMessage(AddPushRegistryPanel.class, "ACSN_AddPush"));
        getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(AddPushRegistryPanel.class, "ACSD_AddPush"));
    }
    
    public void actionPerformed(final java.awt.event.ActionEvent e) {
        if (dd != null)
            dd.setValid(isStateValid());
    }
    
    public void changedUpdate(final javax.swing.event.DocumentEvent e) {
        actionPerformed(null);
    }
    
    public void insertUpdate(final javax.swing.event.DocumentEvent e) {
        actionPerformed(null);
    }
    
    public void removeUpdate(final javax.swing.event.DocumentEvent e) {
        actionPerformed(null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cClass;
    private javax.swing.JPanel errorPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tSender;
    private javax.swing.JTextField tString;
    // End of variables declaration//GEN-END:variables
    
}
