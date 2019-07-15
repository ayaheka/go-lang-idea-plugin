/*
 * Copyright 2013-2016 Sergey Ignatov, Alexander Zolotov, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.notzippy.intellij.go.intellij.actions.tool;

import com.notzippy.intellij.go.intellij.util.GoExecutor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GoVetFileAction extends GoExternalToolsAction {
  @Override
  protected boolean isAvailableOnFile(VirtualFile file) {
    return super.isAvailableOnFile(file) || file.isDirectory();
  }

  @Override
  @NotNull
  protected GoExecutor createExecutor(@NotNull Project project, @Nullable Module module, @NotNull String title, @NotNull String filePath) {
    return GoExecutor.in(project, module).withPresentableName(title).withParameters("tool", "vet", filePath)
      .showNotifications(false, true).showOutputOnError();
  }
}
