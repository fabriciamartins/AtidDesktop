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
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import org.atid.editor.Root;
import org.atid.util.GraphicsTools;

/**
 *
 * @author Martin Riesz <riesz.martin at gmail.com>
 */
public class AboutAction extends AbstractAction {

    private Root root;

    public AboutAction(Root root) {
        this.root = root;
        String name = "About...";
        putValue(NAME, name);
        putValue(SMALL_ICON, GraphicsTools.getIcon("atid/About16.gif"));
        putValue(SHORT_DESCRIPTION, name);
    }

    public void actionPerformed(ActionEvent e) {
       JOptionPane.showOptionDialog(
                root.getParentFrame(),
                root.getAppLongName() + "\n"
                + "\n"
                + "Author: Caio Lucena\n"
                + "             Atylla Gomes\n"
                + "             William Balbino\n"
                        + "\n"
                + "Contributors: Isabel Dillmann Nunes\n"
                + "                      Emerson Borges\n\n"
                + "This program is free software: you can redistribute it and/or modify\n"
                + "it under the terms of the GNU General Public License as published by\n"
                + "the Free Software Foundation, either version 3 of the License, or\n"
                + "(at your option) any later version.\n"
                + "\n"
                + "This program is distributed in the hope that it will be useful,\n"
                + "but WITHOUT ANY WARRANTY; without even the implied warranty of\n"
                + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n"
                + "GNU General Public License for more details.\n"
                + "You should have received a copy of the GNU General Public License\n"
                + "along with this program.  If not, see <http://www.gnu.org/licenses/>.",
                "About",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"OK"},
                "OK");
    }

}
