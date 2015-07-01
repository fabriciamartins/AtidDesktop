/*
 * Copyright (C) 2008-2010 Martin Riesz <riesz.martin at gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.atid.editor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import org.atid.editor.Root;
import org.atid.util.GraphicsTools;

/**
 *
 * @author Martin Riesz <riesz.martin at gmail.com>
 */
public class SimpleActivitySelectToolAction extends AbstractAction {

    private Root root;

    public SimpleActivitySelectToolAction(Root root) {
        this.root = root;
        String name = "Simple Activity";
        putValue(NAME, name);
        putValue(SHORT_DESCRIPTION, name);
        putValue(SMALL_ICON, GraphicsTools.getIcon("atid/place16.gif"));
        putValue(SHORT_DESCRIPTION, "Simple Activity");
        putValue(MNEMONIC_KEY, KeyEvent.VK_P);
//		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("W"));
    }

    public void actionPerformed(ActionEvent e) {
        root.selectTool_SimpleActivity();
    }
}