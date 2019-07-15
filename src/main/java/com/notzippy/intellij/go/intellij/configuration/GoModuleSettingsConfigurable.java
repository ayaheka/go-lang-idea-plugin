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

package com.notzippy.intellij.go.intellij.configuration;

import com.notzippy.intellij.go.intellij.project.GoModuleSettings;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurableBase;
import org.jetbrains.annotations.NotNull;

public class GoModuleSettingsConfigurable extends ConfigurableBase<GoModuleSettingsUI, GoModuleSettings> {
  @NotNull private final Module myModule;
  private final boolean myDialogMode;

  public GoModuleSettingsConfigurable(@NotNull Module module, boolean dialogMode) {
    super("go.project.settings", "Go Project Settings", null);
    myModule = module;
    myDialogMode = dialogMode;
  }

  @NotNull
  @Override
  protected GoModuleSettings getSettings() {
    return GoModuleSettings.getInstance(myModule);
  }

  @Override
  protected GoModuleSettingsUI createUi() {
    return new GoModuleSettingsUI(myModule, myDialogMode);
  }
}
