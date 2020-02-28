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

import org.destinationsol.entitysystem.RegisterEventReceivers;
import org.terasology.gestalt.entitysystem.entity.EntityRef;
import org.terasology.gestalt.entitysystem.event.EventResult;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;

@RegisterEventReceivers
public class EditTextInformationSystem {

    @ReceiveEvent(components = TextInformation.class)
    public EventResult onEditTextInformation(EditTextInformationEvent event, EntityRef entity) {
        entity.getComponent(TextInformation.class).ifPresent(textInformation -> {
            textInformation.setInformation(event.getNewInformation());
            entity.setComponent(textInformation);
        });
        return EventResult.CONTINUE;
    }
}
