/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2016 Oracle and/or its affiliates. All rights reserved.
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
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.cnd.spi.utils;

import java.util.Collection;
import org.netbeans.modules.cnd.utils.CndUtils;
import org.openide.util.Lookup;

/**
 * Implement this to notify about the errors
 */
public abstract class  CndNotifier {
    
    public static enum Priority {
        HIGH,
        NORMAL,
        LOW,
        SILENT
    }
    
    public static enum Category {
        INFO,
        WARNING,
        ERROR
    }
    private static final CndNotifier DEFAULT = new CndErrorNotifierDefault();
    
    
    public static CndNotifier getDefault() {
        if (CndUtils.isStandalone()) {
            return DEFAULT;
        }
        Collection<? extends CndNotifier> notifiers = Lookup.getDefault().lookupAll(CndNotifier.class);
        if (notifiers.isEmpty()) {
            return DEFAULT;
        }
       return notifiers.iterator().next();
    }
    
    /**
     * 
     * @param title
     * @param msg
     */
    abstract public void notifyError(String msg);
    
    /**
     * 
     * @param title
     * @param msg
     */
    abstract public void notifyInfo(String msg);

    /**
     * 
     * @param title
     * @param msg
     */
    abstract public void notifyErrorLater(String msg);   
    
    
    abstract public boolean notifyAndIgnore(String title, String msg);
    
    abstract public void notifyStatus(String text);
    
    
    private static class CndErrorNotifierDefault extends CndNotifier {

        @Override
        public void notifyErrorLater(String msg) {
            notifyError(msg);
        }
        

        @Override
        public void notifyError(String msg) {
            System.err.println(msg);//NOI18N
        }

        @Override
        public void notifyInfo(String msg) {
            System.out.println(msg);//NOI18N
        }

        @Override
        public boolean notifyAndIgnore(String title, String msg) {
           notifyError(msg);
           return true;
        }

        @Override
        public void notifyStatus(String text) {
            System.out.println(text);
        }

    }
    
}
