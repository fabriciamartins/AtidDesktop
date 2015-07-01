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
package org.atid.editor.commands;

import org.atid.petrinet.CompositeActivity;
import org.atid.petrinet.PetriNet;
import org.atid.util.Command;

/**
 *
 * @author Martin Riesz <riesz.martin at gmail.com>
 */
public class AddCompositeActivityCommand implements Command {

    private CompositeActivity compositeActivity;
    private int x, y;
    private CompositeActivity createdCompositeActivity;
    private PetriNet petriNet;

    public AddCompositeActivityCommand(CompositeActivity compositeActivity, int x, int y, PetriNet petriNet) {
        this.compositeActivity = compositeActivity;
        this.x = x;
        this.y = y;
        this.petriNet = petriNet;
    }

    public void execute() {
        createdCompositeActivity = new CompositeActivity();
        createdCompositeActivity.setCenter(x, y);
        petriNet.getNodeSimpleIdGenerator().setUniqueId(createdCompositeActivity);
        petriNet.getNodeLabelGenerator().setLabelToNewlyCreatedNode(createdCompositeActivity);
        compositeActivity.addElement(createdCompositeActivity);
    }

    public void undo() {
        new DeleteElementCommand(createdCompositeActivity).execute();
    }

    public void redo() {
        compositeActivity.addElement(createdCompositeActivity);
    }

    @Override
    public String toString() {
        return "Add Composite Activity ";
    }

}
