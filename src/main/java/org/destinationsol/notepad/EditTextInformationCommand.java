/*
 * Copyright 2020 The Terasology Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.destinationsol.notepad;

import org.destinationsol.common.In;
import org.destinationsol.entitysystem.EntitySystemManager;
import org.destinationsol.game.console.annotations.Command;
import org.destinationsol.game.console.annotations.CommandParam;
import org.destinationsol.game.console.annotations.RegisterCommands;
import org.terasology.gestalt.entitysystem.entity.EntityIterator;

@RegisterCommands
public class EditTextInformationCommand {

    @In
    private EntitySystemManager entitySystemManager;

    @Command(shortDescription = "Edits the text stored under Notepad entity.")
    public void setTextInformation(@CommandParam(value = "text") String text) {
        entitySystemManager.sendEvent(new EditTextInformationEvent(text), new TextInformation());
    }

    @Command(shortDescription = "Displays the text stored under Notepad entity.")
    public String getTextInformation() {
        StringBuilder response = new StringBuilder();
        EntityIterator iterator = entitySystemManager.getEntities(new TextInformation());
        while (iterator.next()) {
            if (iterator.getEntity().getComponent(TextInformation.class).isPresent()) {
                response.append(iterator.getEntity().getComponent(TextInformation.class).get().getInformation());
            }
        }
        return response.toString();
    }
}
