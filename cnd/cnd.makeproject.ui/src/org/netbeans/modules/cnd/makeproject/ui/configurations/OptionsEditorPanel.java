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
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
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

package org.netbeans.modules.cnd.makeproject.ui.configurations;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditorSupport;
import org.netbeans.modules.cnd.makeproject.api.configurations.BooleanConfiguration;
import org.netbeans.modules.cnd.utils.ui.CndUIUtilities;
import org.openide.explorer.propertysheet.PropertyEnv;
import org.openide.util.NbBundle;

public class OptionsEditorPanel extends javax.swing.JPanel implements PropertyChangeListener {
    private final BooleanConfiguration inheritValues;
    private final PropertyEditorSupport editor;

    /** Creates new form CommandLineEditorPanel */
    public OptionsEditorPanel(String[] texts, BooleanConfiguration inheritValues, PropertyEditorSupport editor, PropertyEnv env) {
	this.inheritValues = inheritValues;
        this.editor = editor;
        initComponents();
        // The following line was copied from the generated code (which was reset to default)
        // so I can add an NOI18N comment
        allOptionsTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground")); // NOI18N
        
	additionalLabel.setText(texts[2]);
	allLabel.setText(texts[3]);
        setPreferredSize(new java.awt.Dimension(400, 300));
        CndUIUtilities.requestFocus(additionalOptionsTextArea);
	if (inheritValues != null) {
	    inheritCheckBox.setSelected(inheritValues.getValue());
	}
	else {
	    remove(inheritCheckBox);
	}
        
        env.setState(PropertyEnv.STATE_NEEDS_VALIDATION);
        env.addPropertyChangeListener(this);
        
        // Accessibility
        additionalOptionsTextArea.getAccessibleContext().setAccessibleDescription(getString("ADDITIONAL_OPTIONS_AD"));
        inheritCheckBox.getAccessibleContext().setAccessibleDescription(getString("INHERIT_AD"));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        allLabel = new javax.swing.JLabel();
        allOptionsScrollPane = new javax.swing.JScrollPane();
        allOptionsTextArea = new javax.swing.JTextArea();
        inheritCheckBox = new javax.swing.JCheckBox();
        additionalLabel = new javax.swing.JLabel();
        additionalOptionsScrollPane = new javax.swing.JScrollPane();
        additionalOptionsTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        allLabel.setLabelFor(allOptionsTextArea);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/cnd/makeproject/ui/configurations/Bundle"); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(allLabel, bundle.getString("ALL_OPTIONS_TXT")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 2, 12);
        add(allLabel, gridBagConstraints);

        allOptionsTextArea.setEditable(false);
        allOptionsTextArea.setLineWrap(true);
        allOptionsTextArea.setWrapStyleWord(true);
        allOptionsScrollPane.setViewportView(allOptionsTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 0, 12);
        add(allOptionsScrollPane, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(inheritCheckBox, bundle.getString("INHERIT_TXT")); // NOI18N
        inheritCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inheritCheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 12, 0, 0);
        add(inheritCheckBox, gridBagConstraints);

        additionalLabel.setLabelFor(additionalOptionsTextArea);
        org.openide.awt.Mnemonics.setLocalizedText(additionalLabel, bundle.getString("ADDITIONAL_OPTIONS_TXT")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 2, 12);
        add(additionalLabel, gridBagConstraints);

        additionalOptionsTextArea.setLineWrap(true);
        additionalOptionsTextArea.setWrapStyleWord(true);
        additionalOptionsScrollPane.setViewportView(additionalOptionsTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 12, 12, 12);
        add(additionalOptionsScrollPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void inheritCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inheritCheckBoxActionPerformed
	inheritValues.setValue(inheritCheckBox.isSelected());
    }//GEN-LAST:event_inheritCheckBoxActionPerformed
    
    public String getAdditionalOptions() {
        return additionalOptionsTextArea.getText();
    }
    
    public void setAdditionalOptions(String txt) {
        additionalOptionsTextArea.setText(txt);
    }
    
    public String getAllOptions() {
        return allOptionsTextArea.getText();
    }
    
    public void setAllOptions(String txt) {
        allOptionsTextArea.setText(txt);
    }

    private Object getPropertyValue() throws IllegalStateException {
	// FIXUP: clean for tabs and new lines
	return getAdditionalOptions();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (PropertyEnv.PROP_STATE.equals(evt.getPropertyName()) && evt.getNewValue() == PropertyEnv.STATE_VALID) {
            editor.setValue(getPropertyValue());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel additionalLabel;
    private javax.swing.JScrollPane additionalOptionsScrollPane;
    private javax.swing.JTextArea additionalOptionsTextArea;
    private javax.swing.JLabel allLabel;
    private javax.swing.JScrollPane allOptionsScrollPane;
    private javax.swing.JTextArea allOptionsTextArea;
    private javax.swing.JCheckBox inheritCheckBox;
    // End of variables declaration//GEN-END:variables
    
    private static String getString(String s) {
        return NbBundle.getBundle(OptionsEditorPanel.class).getString(s);
    }
}
