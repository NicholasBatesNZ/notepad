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

import org.destinationsol.assets.Assets;
import org.destinationsol.common.In;
import org.destinationsol.entitysystem.ComponentSystem;
import org.destinationsol.entitysystem.EntitySystemManager;
import org.terasology.gestalt.entitysystem.entity.EntityIterator;

public class TextInformationSystem extends ComponentSystem {

    @In
    private EntitySystemManager entitySystemManager;

    @Override
    public void preBegin() {
        EntityIterator iterator = entitySystemManager.getEntityManager().iterate(new TextInformation());
        while (iterator.next()) {
            if (iterator.getEntity().getComponent(TextInformation.class).isPresent()) {
                return;
            }
        }
        entitySystemManager.getEntityManager().createEntity(Assets.getPrefab("notepad:notepad"));
    }
}
