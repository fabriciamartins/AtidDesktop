/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atid.editor.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import org.atid.editor.Root;
import org.atid.editor.commands.SetArcInhibitCommand;
import org.atid.editor.commands.SetArcResetCommand;
import org.atid.petrinet.Arc;
import org.atid.util.GraphicsTools;

/**
 *
 * @author jan.tancibok
 */
public class SetArcResetAction extends AbstractAction {

    private Root root;

    public SetArcResetAction(Root root) {
        this.root = root;
        String name = "Set/unset reset arc type";
        putValue(NAME, name);
        putValue(SMALL_ICON, GraphicsTools.getIcon("atid/setarcresetaction.gif"));
        putValue(SHORT_DESCRIPTION, name);
        putValue(MNEMONIC_KEY, KeyEvent.VK_I);
        setEnabled(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (root.getClickedElement() != null) {
            if (root.getClickedElement() instanceof Arc) {
                Arc arc = (Arc) root.getClickedElement();
                boolean isReset = arc.getType().equals(Arc.RESET);
                root.getUndoManager().executeCommand(new SetArcResetCommand(arc, !isReset));
            }
        }
    }
}