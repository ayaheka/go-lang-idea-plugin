/*
 * Copyright 2013-2015 Sergey Ignatov, Alexander Zolotov, Florin Patan
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

package com.notzippy.intellij.go.intellij.quickfix;

import com.notzippy.intellij.go.grammar.psi.GoConstDefinition;
import com.notzippy.intellij.go.grammar.psi.GoConstSpec;
import com.intellij.codeInspection.LocalQuickFixBase;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GoDeleteConstDefinitionQuickFix extends LocalQuickFixBase {
  public GoDeleteConstDefinitionQuickFix(@Nullable String constName) {
    super("Delete const " + (constName != null ? "'" + constName + "'" : ""), "Delete constant");
  }

  @Override
  public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
    PsiElement element = descriptor.getPsiElement();
    if (element.isValid() && element instanceof GoConstDefinition) {
      PsiElement parent = element.getParent();
      if (parent instanceof GoConstSpec) {
        ((GoConstSpec)parent).deleteDefinition((GoConstDefinition)element);
      }
    }
  }
}
