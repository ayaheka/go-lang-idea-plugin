/*
 * Copyright 2019-2020 Not zippy
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

// This is a generated file. Not intended for manual editing.
package com.notzippy.intellij.go.grammar.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.notzippy.intellij.go.grammar.psi.GoPsiTreeUtil;
import static com.notzippy.intellij.go.parser.GoTypes.*;
import com.notzippy.intellij.go.stubs.GoTypeSpecStub;
import com.notzippy.intellij.go.grammar.psi.*;
import com.intellij.psi.ResolveState;
import com.intellij.psi.stubs.IStubElementType;

public class GoTypeSpecImpl extends GoNamedElementImpl<GoTypeSpecStub> implements GoTypeSpec {

  public GoTypeSpecImpl(@NotNull GoTypeSpecStub stub, @NotNull IStubElementType type) {
    super(stub, type);
  }

  public GoTypeSpecImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull GoVisitor visitor) {
    visitor.visitTypeSpec(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof GoVisitor) accept((GoVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public GoSpecType getSpecType() {
    return notNullChild(GoPsiTreeUtil.getStubChildOfType(this, GoSpecType.class));
  }

  @Override
  @Nullable
  public GoType getGoTypeInner(@Nullable ResolveState context) {
    return GoPsiImplUtil.getGoTypeInner(this, context);
  }

  @Override
  @NotNull
  public List<GoMethodDeclaration> getMethods() {
    return GoPsiImplUtil.getMethods(this);
  }

  @Override
  public boolean shouldGoDeeper() {
    return GoPsiImplUtil.shouldGoDeeper(this);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    GoSpecType p1 = getSpecType();
    return p1.getIdentifier();
  }

}
